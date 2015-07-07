package com.acme.craft.fixme.solid.single.responsibility.modem;

interface Modem {
	void dial(String pno);

	void hangup();

	void send(char c);

	char recv();
}
