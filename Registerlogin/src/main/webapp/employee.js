// employee.js - Employee management scripts

// Form validation for employee registration/update
function validateEmployeeForm() {
    const firstName = document.getElementById("firstName").value.trim();
    const lastName = document.getElementById("lastName").value.trim();
    const email = document.getElementById("email").value.trim();
    const salary = document.getElementById("salary").value.trim();

    if (firstName === "" || lastName === "" || email === "" || salary === "") {
        alert("Please fill in all required fields!");
        return false;
    }

    // Simple email validation
    const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
    if (!email.match(emailPattern)) {
        alert("Please enter a valid email address!");
        return false;
    }

    // Salary validation
    if (isNaN(salary) || Number(salary) <= 0) {
        alert("Please enter a valid salary amount!");
        return false;
    }

    return true;
}

// Confirm delete employee
function confirmDeleteEmployee(employeeName) {
    return confirm(`Are you sure you want to delete ${employeeName}?`);
}

// Highlight table row on hover (for employee table)
const rows = document.querySelectorAll(".employee-table tbody tr");
rows.forEach(row => {
    row.addEventListener("mouseover", () => row.classList.add("highlight"));
    row.addEventListener("mouseout", () => row.classList.remove("highlight"));
});
