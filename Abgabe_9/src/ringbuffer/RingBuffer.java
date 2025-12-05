package ringbuffer;

class RingBuffer {
    private Element readElement;
    private Element writeElement;

    RingBuffer(int size) {
        Element element = new Element();
        element.next = element;

        for (int i = 0; i < size - 1; i++) {
            Element nextElement = new Element();
            nextElement.next = element.next;
            element.next = nextElement;
        }
        readElement = element;
        writeElement = element;
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
        Element startElement = readElement;
        do {
            if (writeElement == startElement && readElement == startElement) {
                display.append("r/w ");
            } else if (readElement == startElement) {
                display.append("r   ");
            } else if (writeElement == startElement) {
                display.append("w   ");
            } else {
                display.append("    ");
            }
            display.append(startElement.integer).append("\n");
            startElement = startElement.next;

        } while (startElement != readElement);
        return display.toString();
    }


}
