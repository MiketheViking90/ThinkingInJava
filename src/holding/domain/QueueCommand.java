package holding.domain;

public class QueueCommand {

    private String receiver;

    public QueueCommand(String str) {
        receiver = str;
    }

    public void display() {
        System.out.println(receiver);
    }
}
