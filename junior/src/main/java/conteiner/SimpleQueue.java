package conteiner;

public class SimpleQueue<T> {
    private SimpleStack<T> stackTmp;
    private SimpleStack<T> stack;
    private int size;
    public SimpleQueue() {
        stackTmp = new SimpleStack<>();
        stack = new SimpleStack<>();
    }

    public T poll() {
        T rsl = null;
        T stackVal = stack.poll();
        if (stackVal != null) {
            rsl = stackVal;
            this.size--;
        } else {
            T val = stackTmp.poll();
            if (val != null) {
                while (val != null) {
                    stack.push(val);
                    val = stackTmp.poll();
                }
                rsl = stack.poll();
                this.size--;
            }
        }
        return rsl;
    }

    public void push(T value) {
        this.stackTmp.push(value);
        this.size++;
    }
}
