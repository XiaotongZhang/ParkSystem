package ParkManagementSystem_Test;

import ParkManagementSystem.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class superparkingboyTest {

	private Integer totalAmount;
	private ParkingBoy parkingBoy;
	private List<ParkPlace> parkPlaces;

	@Before
	public void init() {
		List<ParkPlace> parkPlaces = new ArrayList<ParkPlace>();
		Integer[] parkPlaceNums = new Integer[] { 10, 20 };
		totalAmount = 0;
		for (Integer parknum : parkPlaceNums) {
			parkPlaces.add(new ParkPlace(parknum));
			totalAmount += parknum;
		}
		parkingBoy = new ParkingBoy(parkPlaces, new MaxVacancyRateLotChooser());
		this.parkPlaces = parkPlaces;
	}

	/*
	 * ���� ͣ��
	 */
	@Test
	public void should_park_Sucess_when_park_is_empty() {
		parkingBoy.park(new Car());
		Assert.assertEquals(new Integer(totalAmount - 1),
				parkingBoy.getAvailableNum());
	}

	/*
	 * ���� ȡ��
	 */
	@Test(expected = NoCarException.class)
	public void should_fetch_Sucess_when_park_is_empty() {
		parkingBoy.fetch(new Ticket());
	}

	/*
	 * ��ȫΪ�� ,ȡ��
	 */
//	@Test(expected = NoCarException.class)
//	public void should_fetch_Sucess_when_park_is_notempty() {
//		for (int i = 0; i < totalAmount / 2; i++) {
//			parkingBoy.park(new Car());
//		}
//		Car car = new Car();
//		Ticket ticket = parkingBoy.park(car);
//		parkingBoy.fetch(ticket);
//	}

	/*
	 * ȫ�� ,ͣ��
	 */
	@Test(expected = NoPlaceException.class)
	public void should_throwParkFullException_if_park_when_park_is_full() {
		for (int i = 0; i < totalAmount; i++) {
			parkingBoy.park(new Car());
		}
		parkingBoy.park(new Car());
	}

	/*
	 * Super Parking Boy���� ͣ��ͣ�ڿճ��ʴ���Ǹ�ͣ����
	 */
	@Test
	public void should_park_in_the_more_VacancyRate_parkplace() {
		// δ����
	}

	/*
	 * super parking boy���� ��������ճ�����ͬʱͣ�ڵ�һ��
	 */
	@Test
	public void should_park_in_the_first_parkplace_if_all_park_VacancyRate_same() {
		// δ����
	}
}
