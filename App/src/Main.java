import java.util.HashMap;
import java.util.Map;

// RoomInventory class (central manager)
class RoomInventory {

  private Map<String, Integer> inventory;

  public RoomInventory() {
    inventory = new HashMap<>();
  }

  // Register room type with count
  public void addRoomType(String roomType, int count) {
    inventory.put(roomType, count);
  }

  // Get availability
  public int getAvailability(String roomType) {
    return inventory.getOrDefault(roomType, 0);
  }

  // Update availability (increase or decrease)
  public void updateAvailability(String roomType, int change) {
    int current = getAvailability(roomType);
    int updated = current + change;

    if (updated < 0) {
      System.out.println("Cannot reduce below zero for " + roomType);
    } else {
      inventory.put(roomType, updated);
    }
  }

  // Display full inventory
  public void displayInventory() {
    System.out.println("\n=== Current Room Inventory ===");
    for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
    System.out.println("==============================");
  }
}

// Main Application
class BookMyStayApp {

  public static void main(String[] args) {

    System.out.println("=== Book My Stay - Inventory System ===");

    // Initialize inventory
    RoomInventory inventory = new RoomInventory();

    // Register room types
    inventory.addRoomType("Standard Room", 10);
    inventory.addRoomType("Deluxe Room", 5);
    inventory.addRoomType("Suite Room", 2);

    // Display initial inventory
    inventory.displayInventory();

    // Simulate updates
    System.out.println("\nBooking 2 Standard Rooms...");
    inventory.updateAvailability("Standard Room", -2);

    System.out.println("Adding 1 Suite Room...");
    inventory.updateAvailability("Suite Room", +1);

    // Display updated inventory
    inventory.displayInventory();

    System.out.println("\nSystem shutting down...");
  }
}