package cop2805;

public class Homework4 {

	public static void main(String[] args) {
		BitOutputStream bitOut = new BitOutputStream();
		bitOut.WriteBit('0');
		bitOut.WriteBit('1');
		bitOut.WriteBit('1');
		bitOut.WriteBit('0');
		bitOut.WriteBit('1');
		bitOut.WriteBit('1');
		bitOut.WriteBit('1');
		bitOut.WriteBit('0');
		bitOut.WriteBit('1');
		bitOut.WriteBit('1');
		bitOut.WriteBit('0');
		bitOut.close();
	}

}
