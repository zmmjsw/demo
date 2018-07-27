package com.test.demo.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.dsig.TransformException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.demo.dao.OrderDao;
import com.test.demo.entity.Order;
import com.test.demo.exception.FailureException;
import com.test.demo.spi.IStableClient;
import com.test.demo.spi.ServiceConfigurer;

/**
 * 
 * @ClassName: StoreProductService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhumingming
 * @date 2018年6月4日 下午4:14:21
 *
 */
@Service
@Transactional
public class OrderService {
	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ServiceConfigurer configurer;

	public void findTimeoutBookingsWithOutClientSource() throws Exception {
		List<Long> list = new ArrayList<Long>();
		for (Long i = 1l; i < 10l; i++) {
			sendBooking(i);
		}

	}

	public void sendBooking(Long bookingId) throws TransformException, Exception, Exception {
		Order booking = orderDao.getOne(bookingId);
		if (booking != null) {

			String messageType = getBookingClientName(booking.getId());
			IStableClient client = (IStableClient) configurer.getClient(messageType);
			if (client == null) {
			} else {
				client.sendMessage(bookingId, true);
			}
		}
	}

	public String getBookingClientName(long sellerId) {
		return sellerId + ".booking";
	}

}
