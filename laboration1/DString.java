package laboration1;

public class DString implements DynamicString { // implementera metoderna i
												// DynamicString - se lab
	private char[] text;
	private int length = 0;

	public DString() {
		this(10);
	}

	public DString(int size) {
		size = (size <= 0) ? 10 : size;
		text = new char[size];
		length = 0;
	}

	public DString(String str) {
		text = str.toCharArray();
		length = text.length;
	}

	public DString(DString str) {
		text = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			text[i] = str.charAt(i);
		}
		length = text.length;
	}

	private void grow() {
		char[] newArr = new char[length * 2];
		System.arraycopy(text, 0, newArr, 0, text.length);
		text = newArr;
	}

	public DynamicString append(char chr) {
		if (length == text.length) {
			grow();
		}
		text[length++] = chr;
		return this;
	}

	public int length() {

		return this.length;
	}

	public char charAt(int index) {

		return this.text[index];
	}

	public DynamicString append(DString str) {

		for (int i = 0; i < str.length(); i++) {
			this.append(str.charAt(i));
		}
		return this;
	}

	public DynamicString delete(int start, int end) {
		char[] newChar = new char[text.length - (end - start)];
		int count = 0;
		for (int i = 0; i < newChar.length; i++) {
			if (i < start || i >= end) {
				newChar[count] = text[i];
				count++;
			}
		}

		text = newChar;
		return this;
	}

	public DynamicString delete(int index) {
		delete(index, index + 1);
		return this;
	}

	public String substring(int start, int end) {
		String ret = "";
		while (start < end) {
			ret += text[start];
			start++;
		}
		return ret;
	}

	public String substring(int start) {
		String ret = "";
		while (start < text.length) {
			ret += text[start];
			start++;
		}
		return ret;
	}

	public int indexOf(char chr) {
		int ret = -1;
		int i = 0;
		while (chr != text[i] && i != text.length) {
			i++;
		}
		if (i != text.length) {
			ret = i;
		}

		return ret;
	}
	
	public String toString(){
		return substring(0, text.length);
		
	}

	public static void main(String[] args) {
		DString str1 = new DString("Laboration");
		str1.append(' ').append('1').append(new DString("\nUppgift3"));
		System.out.println(str1);
		str1.delete(2).delete(4, 6).delete(8);
		System.out.println(str1);
	}
}