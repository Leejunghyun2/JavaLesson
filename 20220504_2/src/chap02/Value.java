package chap02;

public class Value implements Cloneable {
	int value;
	
	Value(int value){
		
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Value) {
			return value == ((Value)obj).value;
		} else {
			return false;
		}
	}

	@Override
	protected Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
		}
		return obj;
	}
	
	
}