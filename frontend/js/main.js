const customerForm = document.getElementById("customerForm");
const roomForm = document.getElementById("roomForm");
const customerTableBody = document.querySelector("#customerTable tbody");
const customerSelect = document.getElementById("customerSelect");
const roomSelect = document.getElementById("roomSelect");

let customers = [];
let rooms = [
    {roomNumber: 101, type: "Single", available: true},
    {roomNumber: 102, type: "Double", available: true},
    {roomNumber: 103, type: "Suite", available: true}
];

// Add customer
customerForm.addEventListener("submit", e => {
    e.preventDefault();
    const id = customers.length + 1;
    const name = document.getElementById("name").value;
    const contact = document.getElementById("contact").value;
    customers.push({id, name, contact});
    refreshCustomerTable();
    refreshCustomerSelect();
    customerForm.reset();
});

// Book room
roomForm.addEventListener("submit", e => {
    e.preventDefault();
    const customerId = parseInt(customerSelect.value);
    const roomNumber = parseInt(roomSelect.value);
    const days = parseInt(document.getElementById("days").value);
    const room = rooms.find(r => r.roomNumber === roomNumber);
    if (!room.available) {
        alert("Room not available!");
        return;
    }
    room.available = false;
    alert(`Room ${room.roomNumber} booked for ${days} days by ${customers.find(c => c.id === customerId).name}`);
    refreshRoomSelect();
    roomForm.reset();
});

// Refresh table
function refreshCustomerTable() {
    customerTableBody.innerHTML = "";
    customers.forEach(c => {
        customerTableBody.innerHTML += `<tr><td>${c.id}</td><td>${c.name}</td><td>${c.contact}</td></tr>`;
    });
}

// Refresh dropdowns
function refreshCustomerSelect() {
    customerSelect.innerHTML = "";
    customers.forEach(c => {
        customerSelect.innerHTML += `<option value="${c.id}">${c.name}</option>`;
    });
}

function refreshRoomSelect() {
    roomSelect.innerHTML = "";
    rooms.forEach(r => {
        if (r.available) roomSelect.innerHTML += `<option value="${r.roomNumber}">${r.type} - ${r.roomNumber}</option>`;
    });
}

// Initial load
refreshCustomerTable();
refreshCustomerSelect();
refreshRoomSelect();
