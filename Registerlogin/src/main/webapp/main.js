// main.js - General scripts for the payroll system

// Toggle sidebar menu (if you have a dashboard sidebar)
const toggleBtn = document.querySelector("#menu-toggle");
const sidebar = document.querySelector("#sidebar");

if (toggleBtn) {
    toggleBtn.addEventListener("click", () => {
        sidebar.classList.toggle("collapsed");
    });
}

// Alert notifications
function showAlert(message, type = "success") {
    const alertBox = document.createElement("div");
    alertBox.className = `alert alert-${type}`;
    alertBox.innerText = message;

    document.body.appendChild(alertBox);

    setTimeout(() => {
        alertBox.remove();
    }, 3000);
}

// Confirm before deleting
function confirmDelete(message = "Are you sure you want to delete?") {
    return window.confirm(message);
}

// Smooth scroll to top button
const scrollTopBtn = document.querySelector("#scrollTopBtn");
if (scrollTopBtn) {
    scrollTopBtn.addEventListener("click", () => {
        window.scrollTo({ top: 0, behavior: "smooth" });
    });
}
