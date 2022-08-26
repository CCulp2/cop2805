package cop2805;
import java.util.*;

public class BitOutputStream 
{
	//I found a Stack of Boolean values to be a useful data structure
	//But this is optional, feel free to use something else
	Stack<Boolean> buffer;

	BitOutputStream()
	{
		buffer = new Stack<Boolean>();
	}
	
	public void WriteBit(char bit)
	{
		Character x = bit;

		/* No "type" safety here. Would have to confirm additions.
		Because I'm calling buffer.add() instead of buffer.push() I'm adding things in chronological order.
		Defeats the purpose of a stack, returns the correct results.
		 */
		buffer.add(x.equals('1'));
		if (buffer.size() == 8) {
			OutputByte();
			buffer.clear();
		}
	}
	
	public void close()
	{
		OutputByte();
		buffer.clear();
	}
	
	//This is an optional function to convert the buffer to a Byte 
	//and output it to the screen. When this is called
	//it should leave the buffer empty.
	private void OutputByte()
	{
		int exp = 1;
		byte b = 0;

		while (!buffer.empty()) {

			b += buffer.pop() ? exp : 0;
			exp *=2;
		}
		System.out.println(b);
	}

}
