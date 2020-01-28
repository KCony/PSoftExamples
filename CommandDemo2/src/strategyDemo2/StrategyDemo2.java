package strategyDemo2;

interface FileSystemReceiver {

	void openFile();
	void writeFile();
	void closeFile();
}

class UnixFileSystemReceiver implements FileSystemReceiver {

	@Override
	public void openFile() {
		System.out.println("Opening file in unix OS");
	}

	@Override
	public void writeFile() {
		System.out.println("Writing file in unix OS");
	}

	@Override
	public void closeFile() {
		System.out.println("Closing file in unix OS");
	}

}

class WindowsFileSystemReceiver implements FileSystemReceiver {

	@Override
	public void openFile() {
		System.out.println("Opening file in Windows OS");

	}

	@Override
	public void writeFile() {
		System.out.println("Writing file in Windows OS");
	}

	@Override
	public void closeFile() {
		System.out.println("Closing file in Windows OS");
	}

}

interface Command {

	void execute();
}

class OpenFileCommand implements Command {

	private FileSystemReceiver fileSystem;

	public OpenFileCommand(FileSystemReceiver fs){
		this.fileSystem=fs;
	}
	@Override
	public void execute() {
		//open command is forwarding request to openFile method
		this.fileSystem.openFile();
	}

}

class CloseFileCommand implements Command {

	private FileSystemReceiver fileSystem;

	public CloseFileCommand(FileSystemReceiver fs){
		this.fileSystem=fs;
	}
	@Override
	public void execute() {
		this.fileSystem.closeFile();
	}

}

class WriteFileCommand implements Command {

	private FileSystemReceiver fileSystem;

	public WriteFileCommand(FileSystemReceiver fs){
		this.fileSystem=fs;
	}
	@Override
	public void execute() {
		this.fileSystem.writeFile();
	}

}

class FileInvoker {

	public Command command;

	public FileInvoker(Command c){
		this.command=c;
	}

	public void execute(){
		this.command.execute();
	}
}

class FileSystemReceiverUtil {

	public static FileSystemReceiver getUnderlyingFileSystem(){
		String osName = System.getProperty("os.name");
		System.out.println("Underlying OS is:"+osName);
		if(osName.contains("Windows")){
			return new WindowsFileSystemReceiver();
		}else{
			return new UnixFileSystemReceiver();
		}
	}

}

public class StrategyDemo2 {
	public static void main(String[] args) {
		//Creating the receiver object
		FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();

		//creating command and associating with receiver
		OpenFileCommand openFileCommand = new OpenFileCommand(fs);

		//Creating invoker and associating with Command
		FileInvoker file = new FileInvoker(openFileCommand);

		//perform action on invoker object
		file.execute();

		WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
		file = new FileInvoker(writeFileCommand);
		file.execute();

		CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
		file = new FileInvoker(closeFileCommand);
		file.execute();
	}

}
