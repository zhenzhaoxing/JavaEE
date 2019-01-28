import java.io.IOException;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
public class baseDemo {

	public void fun1() throws IOException {
		
		// BASE64编码
		String s = "ILOVEYOU";
		BASE64Encoder encoder = new BASE64Encoder();
//		 把字符串转换成字节
		s = encoder.encode(s.getBytes("UTF-8"));
		System.out.println(s);
		
		System.out.println("--------------");
		
		// BASE64解码
		BASE64Decoder decoder = new BASE64Decoder();
//	 把字节转换成字符串
		byte[] bytes = decoder.decodeBuffer("SPVkVZ=");
		String n = new String(bytes,"UTF-8");
		System.out.println(n);
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		baseDemo s =  new baseDemo();
		try {
			s.fun1();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
