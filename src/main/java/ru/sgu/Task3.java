interface Handler {
    void handleRequest(Request request);
    void setNextHandler(Handler nextHandler);
}

class HandlerFirst implements Handler {
    private Handler nextHandler;

    @Override
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE1) {
            System.out.println("Обработчик 1 обрабатывает запрос " + request + "и завершает цепочку");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

class HandlerSecond implements Handler {
    private Handler nextHandler;

    @Override
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE2) {
            System.out.println("Обработчик 2 обрабатывает запрос " + request + " но не завершает и передает дальше");
        }

        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

enum RequestType {
    TYPE1, TYPE2
}

class Request {
    private RequestType type;

    public Request(RequestType type) {
        this.type = type;
    }

    public RequestType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type=" + type +
                '}';
    }
}

public class Task3 {
    public static void main(String[] args) {

        Handler handler1 = new HandlerFirst();
        Handler handler2 = new HandlerSecond();
        Handler handler3 = new HandlerFirst();
        Handler handler4 = new HandlerSecond();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        handler3.setNextHandler(handler4);

        Request request1 = new Request(RequestType.TYPE1);
        Request request2 = new Request(RequestType.TYPE2);

        System.out.println("First request:");
        handler1.handleRequest(request1);

        System.out.println("Second request:");
        handler1.handleRequest(request2);
    }
}

