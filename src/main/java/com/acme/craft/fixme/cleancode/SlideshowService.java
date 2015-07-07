package com.acme.craft.fixme.cleancode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SlideshowService {

	private ResourceHolderResourceRepository resourceHolderResourceRepository;
	private scheduleRepository scheduleRepository;

	public SlideshowData generateTimelineData(String resourceHolderId, String contentId) throws Exception {

		Resource resource = resourceHolderResourceRepository.findOne(contentId);

		Asset defaultAsset = getDefaultAsset(resource);

		Slideshow slideshow = SlideshowFactory.getSlideshow(defaultAsset);
		ResourceSchedule schedule = scheduleRepository.findOne(resource.getScheduleId());
		validateSchedule(schedule);

		Set<String> resourceIds = new HashSet<>();
		getResourceIds(schedule, resourceIds);

		Iterable<Resource> resourcesSet = resourceHolderResourceRepository.findAll(resourceIds);
		HashMap<String, Asset> assets = resourcesToAssetMap(resourcesSet);

		List<SlideshowInterval> timeLineIntervalList = new ArrayList<>();

		int slide = findTimeLineIntervalList(defaultAsset, schedule, assets, timeLineIntervalList);

		slideshow.setDate(timeLineIntervalList);
		return new SlideshowData(slideshow, slide);
	}

	public int findTimeLineIntervalList(Asset defaultAsset, ResourceSchedule schedule, HashMap<String, Asset> assets,
			List<SlideshowInterval> timeLineIntervalList) {
		Calendar calendar = GregorianCalendar.getInstance();
		int slide = 0;
		int MAX_COUNT = schedule.getResourceSchedules().size() - 1;
		for (int i = 0; i < MAX_COUNT; ++i) {
			ResourceSchedule resourceSchedule = schedule.getResourceSchedules().get(i);
			if (calendar.getTimeInMillis() > resourceSchedule.getStartTime()) {
				++slide;
			}
			timeLineIntervalList
					.add(resourceScheduleToDate(resourceSchedule, assets.get(resourceSchedule.getResourceId())));
			if (defaultAsset != null) {
				if (resourceSchedule.getEndTime() != schedule.getResourceSchedules().get(i + 1).getStartTime()) {
					if (resourceSchedule.getEndTime() < calendar.getTimeInMillis()) {
						++slide;
					}
					timeLineIntervalList.add(defaultDate(resourceSchedule.getEndTime(),
							schedule.getResourceSchedules().get(i + 1).getStartTime(), defaultAsset));
				}
			}
		}

		if (schedule.getResourceSchedules().size() > 0) {
			ResourceSchedule lastResourceSchedule = schedule.getResourceSchedules().get(MAX_COUNT);
			if (calendar.getTimeInMillis() > lastResourceSchedule.getEndTime()) {
				slide = 0;
			}

			timeLineIntervalList.add(
					resourceScheduleToDate(lastResourceSchedule, assets.get(lastResourceSchedule.getResourceId())));
		}
		return slide;
	}

	public Asset getDefaultAsset(Resource resource) {
		Asset defaultAsset = null;
		if (resource != null) {
			defaultAsset = resourceToAsset(resource);
		}
		return defaultAsset;
	}

	public void getResourceIds(ResourceSchedule schedule, Set<String> resourceIds) {
		for (ResourceSchedule item : schedule.getResourceSchedules()) {
			resourceIds.add(item.getResourceId());
		}
	}

	public void validateSchedule(ResourceSchedule schedule) throws Exception {
		if (schedule == null) {
			throw new Exception("");
		}

		if (schedule.getResourceSchedules().size() == 0) {
			throw new Exception("", null);
		}
	}

	public void validateResoruceHolder(ResourceHolder resourceHolder) throws Exception {
		if (resourceHolder == null) {
			throw new Exception("some error");
		}
	}

	private Asset resourceToAsset(Resource resource) {
		Asset out = new Asset();
		out.setMedia(resource.getId());
		out.setCredit(resource.getContentType());
		out.setCaption(resource.getName());
		out.setThumbnail(resource.getId());
		return out;
	}

	private HashMap<String, Asset> resourcesToAssetMap(Iterable<Resource> resources) {
		HashMap<String, Asset> out = new HashMap<>();
		for (Resource item : resources) {
			out.put(item.getId(), resourceToAsset(item));
		}
		return out;
	}

	private SlideshowInterval resourceScheduleToDate(ResourceSchedule schedule, Asset asset) {
		SlideshowInterval out = new SlideshowInterval();
		out.setStartDate(timestampToTimelineDate(schedule.getStartTime()));
		out.setEndDate(timestampToTimelineDate(schedule.getEndTime()));
		out.setHeadline(schedule.getName());
		out.setAsset(asset);
		return out;
	}

	private SlideshowInterval defaultDate(long start, long end, Asset asset) {
		SlideshowInterval out = new SlideshowInterval();
		out.setStartDate(timestampToTimelineDate(start));
		out.setEndDate(timestampToTimelineDate(end));
		out.setHeadline("Default Content");
		out.setAsset(asset);
		return out;
	}

	private String timestampToTimelineDate(long timestamp) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTimeInMillis(timestamp);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(calendar.get(Calendar.YEAR)).append(",").append(calendar.get(Calendar.MONTH) + 1)
				.append(",").append(calendar.get(Calendar.DAY_OF_MONTH)).append(",")
				.append(calendar.get(Calendar.HOUR_OF_DAY)).append(",").append(calendar.get(Calendar.MINUTE));
		return stringBuilder.toString();
	}

}
