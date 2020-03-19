package easykotlin;

public class VarArgsDemo<T> {
    static VarArgsDemo vad = new VarArgsDemo();

    public String append(T... element) {
        StringBuilder sb = new StringBuilder();
        for (T e : element) {
            sb.append(e);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(vad.append("a", "b", "c"));
        System.out.println(vad.append(1, 2, 3));
        System.out.println(vad.append(1, "b", "c"));
    }

}
