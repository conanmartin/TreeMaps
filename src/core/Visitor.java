package core;

import impl.Position;

public interface Visitor<T> {
	public void visit(Position<T> p, Object data);
}
