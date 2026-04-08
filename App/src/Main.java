import java.util.*;

// Reservation class (represents a booking request)
class Reservation {
  private String guestName;
  private String roomType;

  public Reservation(String guestName, String roomType) {
    this.guestName = guestName;
    this.roomType = roomType;
  }

  public String getGuestName() {
    return guestName;
  }

  public String getRoomType() {
    return roomType;
  }

  @Override
  public String toString() {
    return "Guest: " + guestName + " | Room Type: " + roomType;
  }
}

// Booking Request Queue (FIFO)
class BookingRequestQueue {

  private Queue<Reservation> queue;

  public BookingRequestQueue() {
    queue = new LinkedList<>();
  }

  // Add booking request
  public void addRequest(Reservation reservation) {
    queue.offer(reservation);
    System.out.println("Request added: " + reservation);
  }

  // View all queued requests
  public void displayQueue() {
    System.out.println("\n=== Booking Request Queue ===");

    if (queue.isEmpty()) {
      System.out.println("No pending requests.");
      return;
    }

    for (Reservation r : queue) {
      System.out.println(r);
    }
  }

  // Peek next request (without removing)
  public Reservation peekNext() {
    return queue.peek();
  }
}

// Main Application
class BookMyStayApp {

  public static void main(String[] args) {

    System.out.println("=== Book My Stay - Booking Queue ===");

    // Initialize booking queue
    BookingRequestQueue bookingQueue = new BookingRequestQueue();

    // Simulate guest booking requests
    bookingQueue.addRequest(new Reservation("Alice", "Standard Room"));
    bookingQueue.addRequest(new Reservation("Bob", "Suite Room"));
    bookingQueue.addRequest(new Reservation("Charlie", "Deluxe Room"));

    // Display queue (FCFS order)
    bookingQueue.displayQueue();

    // Show next request to be processed
    System.out.println("\nNext request to process: " + bookingQueue.peekNext());

    System.out.println("\nRequests are queued. Waiting for allocation system...");
  }
}