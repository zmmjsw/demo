package com.test.demo.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class test3 {
	public static void main(String[] args) {
	    String str="00:IFTMBF:BOOKING:9:BFWL::201807261656'10::新杭州:s:::d::20180727'11::::YIK:'12:YIK:营口:HPO:黄埔老港:HPO:黄埔老港:::营口:黄埔老港:黄埔老港'14:SENDER:::YHT2532595381::YIK::CY-CFS:P:YIK03015142V1:::::::::R'20::dfg^dfg^^^dfg:20::'21::fgh^fgh^^^fgh:21::::'22::fgh^fgh^^^fgh:22::::'40:20GP:1:F:::N'41::::1:CN:CN:27000.000:1::::::'44:'47:冷卷  '60:P:FREIGHT PREPAID::'70:客户代结港杂费*免收换单费*'71:电放:::::'99:1' ";
	    
	    str = str.replaceAll("\\^", "\n").replaceAll("\\?:", ":")
				.replaceAll("\\?'", "'");
	    System.out.println(str);
	    
	    
	  /*  str=String.format("Hi,%s", "飞龙");          // 格式化字符串
	    System.out.println(String.format("%s", "<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?><event><eventHeader><eventType>DELIVERY_INSTRUCTION</eventType><eventTime>2018-07-25 14:11:41</eventTime><eventSource>ZPMC</eventSource><eventTarget>YiHaiTong</eventTarget></eventHeader><eventBody><deliveryPlanNo>1807250004</deliveryPlanNo><contractNo>1002000187-0002</contractNo><supplier>Siemens AG</supplier><buyer>陈翔</buyer><buyerPhone></buyerPhone><buyerEmail></buyerEmail><goodsName>电控散件</goodsName><pickupAddress>SIEMENS Dettmer Container Packing (DCP) Hamburg</pickupAddress><pickupContact>Andrea Schulze</pickupContact><pickupPhone> 49 9131 98-4552</pickupPhone><pod>上海</pod><dueDate>2018-07-31</dueDate><specialRequirement></specialRequirement><planPickupDate>2018-06-30</planPickupDate><tradeType>FCA</tradeType><status>SUBMITTED</status><cargoValue>0.00</cargoValue><cargoValueCurrency></cargoValueCurrency></eventBody></event>"));                             // 输出字符串变量str的内容
	    System.out.println(str);                             // 输出字符串变量str的内容
	    System.out.printf("字母a的大写是：%c %n", 'A');
	    System.out.printf("3>7的结果是：%b %n", 3>7);
	    System.out.printf("100的一半是：%d %n", 100/2);
	    System.out.printf("100的16进制数是：%x %n", 100);
	    System.out.printf("100的8进制数是：%o %n", 100);
	    System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);
	    System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);
	    System.out.printf("上面价格的指数表示：%e %n", 50*0.85);
	    System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);
	    System.out.printf("上面的折扣是%d%% %n", 85);
	    System.out.printf("字母A的散列码是：%h %n", 'A');*/
		

	}
	
	public InputStream getInputStream(FileInputStream fileInput) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024*4];
		int n = -1;
		InputStream inputStream = null;
		try {
			while ((n=fileInput.read(buffer)) != -1) {
				baos.write(buffer, 0, n);
				
			}
			byte[] byteArray = baos.toByteArray();
			inputStream = new ByteArrayInputStream(byteArray);
			return inputStream;
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	private void savePic(InputStream inputStream, String fileName) {

        OutputStream os = null;
        try {
            String path = "D:\\testFile\\";
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件

            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


	public static List<PriceDto> obtainTotalPriceDtoWithAllCurrency(List<OrderCharge> charges) {
		List<PriceDto> priceDtoList = Lists.newArrayList();
		Map<String, List<OrderCharge>> collect = null;
		for (Map.Entry<String, List<OrderCharge>> entry : collect.entrySet()) {
			PriceDto priceDto = new PriceDto();
			priceDto.setCurrency(entry.getKey());
			List<OrderCharge> value = entry.getValue();
			Stream<BigDecimal> map = value.stream().map(c -> c.getPrice().multiply((BigDecimal) c.getQty()));
			priceDto.setTotalPrice(value.stream().map(c -> c.getPrice().multiply((BigDecimal) c.getQty()))
					.reduce((x, y) -> x.add(y)).get());
			priceDtoList.add(priceDto);
		}
		return priceDtoList;
	}

	private static boolean isIgnoredCharge(OrderCharge c) {
		return ChargeStatus.CANCELLED.equals("")
				|| ChargeStatus.REFUSED.equals("");
	}

}
