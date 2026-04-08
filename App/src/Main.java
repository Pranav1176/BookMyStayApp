import java.util.*;

// Room class (same concept reused)
class Room {
  private String type;
  private double price;

  public Room(String type, double price) {
    this.type = type;
    this.price = price;
  }

  public String getType() {
    return type;
  }

  public double getPrice() {
    return price;
  }
}

// Centralized Inventory (from Use Case 3)
class RoomInventory {
  private Map<String, Integer> inventory = new HashMap<>();

  public void addRoomType(String type, int count) {
    inventory.put(type, count);
  }

  public int getAvailability(String type) {
    return inventory.getOrDefault(type, 0);
  }

  public Map<String, Integer> getAllInventory() {
    return inventory; // read-only usage expected
  }
}

// Search Service (READ-ONLY)
class RoomSearchService {

  private RoomInventory inventory;
  private Map<String, Room> roomDetails;

  public RoomSearchService(RoomInventory inventory, Map<String, Room> roomDetails) {
    this.inventory = inventory;
    this.roomDetails = roomDetails;
  }

  public void searchAvailableRooms() {
    System.out.println("\n=== Available Rooms ===");

    for (String type : roomDetails.keySet()) {
      int available = inventory.getAvailability(type);

      // Filter unavailable rooms
      if (available > 0) {
        Room room = roomDetails.get(type);
        System.out.println("Room Type: " + room.getType());
        System.out.println("Price: ₹" + room.getPrice());
        System.out.println("Available: " + available);
        System.out.println("------------------------");
      }
    }
  }
}

// Main Application
class BookMyStayApp {

  public static void main(String[] args) {

    System.out.println("=== Book My Stay - Room Search ===");

    // Step 1: Initialize inventory
    RoomInventory inventory = new RoomInventory();
    inventory.addRoomType("Standard Room", 10);
    inventory.addRoomType("Deluxe Room", 0); // unavailable
    inventory.addRoomType("Suite Room", 2);

    // Step 2: Room details (separate from inventory)
    Map<String, Room> roomDetails = new HashMap<>();
    roomDetails.put("Standard Room", new Room("Standard Room", 2000));
    roomDetails.put("Deluxe Room", new Room("Deluxe Room", 3500));
    roomDetails.put("Suite Room", new Room("Suite Room", 5000));

    // Step 3: Search service
    RoomSearchService searchService = new RoomSearchService(inventory, roomDetails);

    // Step 4: Guest searches rooms
    searchService.searchAvailableRooms();

    System.out.println("\nSearch completed. System state unchanged.");
  }
}