package io.io;

public class Args {
    private String[] arguments;
    private String keyDir = "-d";
    private String keyName = "-n";
    private String keyLog = "-o";
    private String keyMask = "-m";

    public Args(String[] arguments) {
        this.arguments = arguments;
    }

    public String directory() {
        return checkArgs(keyDir);
    }

    public String nameFile() {
        return checkArgs(keyName);
    }

    public boolean mask() {
        for (String str : this.arguments) {
            if (str.equals(keyMask)) {
                return true;
            }

        }
        return false;
    }
    public String exclude() {
        return checkArgs("-e");
    }

    public String output() {
        return checkArgs(keyLog);
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
