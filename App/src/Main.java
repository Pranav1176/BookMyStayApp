// Abstract base class
abstract class Room {
  protected String roomType;
  protected double pricePerNight;
  protected int availableRooms;

  public Room(String roomType, double pricePerNight, int availableRooms) {
    this.roomType = roomType;
    this.pricePerNight = pricePerNight;
    this.availableRooms = availableRooms;
  }

  // Abstract method
  public abstract void displayDetails();
}

// Standard Room class
class StandardRoom extends Room {

  public StandardRoom(int availableRooms) {
    super("Standard Room", 2000.0, availableRooms);
  }

  @Override
  public void displayDetails() {
    System.out.println("Room Type: " + roomType);
    System.out.println("Price per Night: ₹" + pricePerNight);
    System.out.println("Available Rooms: " + availableRooms);
    System.out.println("-----------------------------");
  }
}

// Deluxe Room class
class DeluxeRoom extends Room {

  public DeluxeRoom(int availableRooms) {
    super("Deluxe Room", 3500.0, availableRooms);
  }

  @Override
  public void displayDetails() {
    System.out.println("Room Type: " + roomType);
    System.out.println("Price per Night: ₹" + pricePerNight);
    System.out.println("Available Rooms: " + availableRooms);
    System.out.println("-----------------------------");
  }
}

// Suite Room class
class SuiteRoom extends Room {

  public SuiteRoom(int availableRooms) {
    super("Suite Room", 5000.0, availableRooms);
  }

  @Override
  public void displayDetails() {
    System.out.println("Room Type: " + roomType);
    System.out.println("Price per Night: ₹" + pricePerNight);
    System.out.println("Available Rooms: " + availableRooms);
    System.out.println("-----------------------------");
  }
}

// Main application
class BookMyStayApp {

  public static void main(String[] args) {

    System.out.println("=== Welcome to Book My Stay ===");

    // Create room objects with static availability
    Room standard = new StandardRoom(10);
    Room deluxe = new DeluxeRoom(5);
    Room suite = new SuiteRoom(2);

    // Display details
    standard.displayDetails();
    deluxe.displayDetails();
    suite.displayDetails();

    System.out.println("Thank you for visiting!");
  }
}