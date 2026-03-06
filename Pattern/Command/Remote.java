class Remote {

    private Command command;

    public void setCommand(Command command) {
        this.command = command; 
    }

    public void press () {
        command.execute();
    }

    public void undo() {
        command.undo();
    }

}