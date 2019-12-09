package io.io;

public class Args {
    private String[] arguments;

    public Args(String[] arguments) {
        this.arguments = arguments;
    }

    public String directory() {
        return checkArgs("-d");
    }

    public String exclude() {
        return checkArgs("-e");
    }

    public String output() {
        return checkArgs("-o");
    }

    public String checkArgs(String arg) {
        String result = null;
        for (int i = 0; i < this.arguments.length; i++) {
            if (this.arguments[i].equals(arg)) {
                result = this.arguments[i + 1];
                break;
            }
        }
        return result;
    }
}
