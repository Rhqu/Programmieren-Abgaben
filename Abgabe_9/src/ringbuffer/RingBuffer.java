package ringbuffer;

public class RingBuffer {
    Element readElement;
    Element writeElement;

    RingBuffer(int size) {
        Element element = new Element();
        element.next = element;
        for (int i = 0; i < size; i++) {
            Element nextElement = new Element();
            element.next = nextElement;
            nextElement.next = nextElement;
        }
        writeElement = element;
        readElement = element;
    }

    Integer read() {
        Integer returnInteger = readElement.integer;
        this.readElement = readElement.next;
        return returnInteger;
    }

    void write(Integer integer) {
        this.writeElement.integer = integer;
        this.writeElement = this.writeElement.next;
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        Element startElement = readElement.next;
        do {
            if (readElement == writeElement){
                display.append("w/r ");
            } else if (readElement == startElement) {
                display.append("r ");
            } else if (writeElement == startElement);
        } while (startElement != readElement.next){

        }

    }


}
