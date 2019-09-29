/**
 * 
 */
package test;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月19日 下午8:31:15
 */
public class InstrumentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		testPlay(new Piano(),"钢琴");
		testPlay(new Violin(),"小提琴");
		testPlay(new Guitar(),"吉他");
		
	}
	public static void testPlay(Instrument instrument,String name) {
		instrument.name = name;
		instrument.play();
	}
	
	
}
