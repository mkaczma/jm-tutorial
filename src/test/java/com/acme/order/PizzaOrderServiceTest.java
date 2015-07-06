package com.acme.order;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class PizzaOrderServiceTest {

	private PizzaOrderService pizzaOrderService;
	private MailSender mailSender;
	private OrderDatabase orderDatabase;
	private OrderFactory orderFactory;
	private DeliveryTimeService deliveryTimeService;
	private MessageTemplateService messageTemplate;

	@Before
	public void init() {
		mailSender = Mockito.mock(MailSender.class);
		orderDatabase = Mockito.mock(OrderDatabase.class);
		orderFactory = Mockito.mock(OrderFactory.class);
		deliveryTimeService = Mockito.mock(DeliveryTimeService.class);
		messageTemplate = Mockito.mock(MessageTemplateService.class);
		pizzaOrderService = new PizzaOrderService(mailSender, orderDatabase, orderFactory, deliveryTimeService,
				messageTemplate);
	}
	
	@Test
	public void createdOrder(){
		Customer customer = givenCustomer();
		PizzaType type = Mockito.mock(PizzaType.class);
		PizzaOrder givenOrder = new PizzaOrder(customer, type);
		Date date = new Date();
		Mockito.when(deliveryTimeService.getTime(Mockito.any(), Mockito.any())).thenReturn(date);
		Mockito.when(orderFactory.create(Mockito.any(), Mockito.any())).thenReturn(givenOrder);
		
		pizzaOrderService.createOrder(customer, type);
		
		Assert.assertTrue(givenOrder.getEstimatedTime().equals(date));
		
		ArgumentCaptor<PizzaOrder> savedPizzaOrder = ArgumentCaptor.forClass(PizzaOrder.class);
		Mockito.verify(orderDatabase).save(savedPizzaOrder.capture());
		Assert.assertTrue(savedPizzaOrder.getValue().equals(givenOrder));
		
		DeliveryTemplate deliveryTemplate = Mockito.mock(DeliveryTemplate.class);
		Mockito.when(messageTemplate.getDeliveryTemplpate()).thenReturn(deliveryTemplate);
		ArgumentCaptor<String> sentEmailAdress = ArgumentCaptor.forClass(String.class);
		Mockito.verify(mailSender).send(Mockito.any(DeliveryTemplate.class), sentEmailAdress.capture());
		
	}


	@Test
	public void cancelledOrderShouldBePersistedAndEmailShouldBeSend() {
		// given
		String pizzaOrderId = "fake_id";
		PizzaOrder givenPizzaOrder = givenPizzaOrder();
		OrderCanceledTemplate template = Mockito.mock(OrderCanceledTemplate.class);
		// stub - uczymy jak nasz mock ma sie zachowywac
		Mockito.when(orderDatabase.get(Mockito.anyString())).thenReturn(givenPizzaOrder);
		Mockito.when(messageTemplate.getCancelTemplate()).thenReturn(template);
		// when
		pizzaOrderService.cancelOrder(pizzaOrderId);
		// then
		Assert.assertTrue(givenPizzaOrder.isCancelled());
		ArgumentCaptor<String> sentEmailAdress = ArgumentCaptor.forClass(String.class);
		Mockito.verify(mailSender).send(Mockito.any(Template.class), sentEmailAdress.capture());
//		Assert.assertTrue(sentEmailAdress.getValue().equals(givenPizzaOrder.getEmail()));
		
		ArgumentCaptor<PizzaOrder> savedPizzaOrder = ArgumentCaptor.forClass(PizzaOrder.class);
		Mockito.verify(orderDatabase).save(savedPizzaOrder.capture());
		Assert.assertTrue(savedPizzaOrder.getValue().equals(givenPizzaOrder));
	}

	public PizzaOrder givenPizzaOrder() {
		Customer customer = givenCustomer();
		PizzaType type = Mockito.mock(PizzaType.class);
		PizzaOrder givenOrder = new PizzaOrder(customer, type);
		return givenOrder;
	}

	public Customer givenCustomer() {
		String customerEmail = "fake_email";
		Customer customer = new Customer();
		return customer;
	}

}
