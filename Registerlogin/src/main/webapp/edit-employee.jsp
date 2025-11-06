<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>About | PAY ZEN - Employee Payroll System</title>
  <link rel="icon" href="favicon.ico" type="image/x-icon" />
  <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
  <style>
    /* ===== GLOBAL ===== */
    :root {
      --primary: #007BFF;         /* Updated Blue Color */
      --primary-dark: #0056b3;    /* Darker Shade for Hover */
      --dark: #1e2a38;
      --text: #444;
      --light: #f5f7fa;
      --shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
    }

    body {
      margin: 0;
      font-family: "Poppins", sans-serif;
      background-color: var(--light);
      color: var(--text);
    }

    h1, h2, h3 {
      color: var(--dark);
      font-weight: 700;
    }

    p {
      line-height: 1.7;
    }

    a {
      text-decoration: none;
      color: inherit;
    }

    /* ===== NAVBAR ===== */
    .navbar {
      background-color: var(--dark);
      color: #fff;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 20px 60px;
      position: sticky;
      top: 0;
      z-index: 1000;
      box-shadow: var(--shadow);
    }

    .navbar .logo {
      font-size: 1.9rem;
      font-weight: 700;
      letter-spacing: 1px;
    }

    .navbar ul {
      display: flex;
      list-style: none;
      gap: 30px;
      margin: 0;
      padding: 0;
    }

    .navbar ul li a {
      color: #fff;
      font-size: 1rem;
      transition: color 0.3s ease;
    }

    .navbar ul li a:hover,
    .navbar ul li a.active {
      color: var(--primary);
    }

    /* ===== HERO ===== */
    .hero {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      align-items: center;
      padding: 100px 60px;
      background: linear-gradient(120deg, #ffffff, #eaf0ff);
      border-bottom: 4px solid var(--primary);
    }

    .hero-text {
      flex: 1;
      min-width: 300px;
      padding-right: 40px;
    }

    .hero-text h1 {
      font-size: 3rem;
      margin-bottom: 20px;
    }

    .hero-text h1 span {
      color: var(--primary);
    }

    .hero-text p {
      font-size: 1.1rem;
      margin-bottom: 30px;
      color: #555;
    }

    .btn {
      display: inline-block;
      background-color: var(--primary);
      color: #fff;
      padding: 12px 30px;
      border-radius: 8px;
      transition: background 0.3s ease;
      font-weight: 500;
    }

    .btn:hover {
      background-color: var(--primary-dark);
    }

    .hero-image {
      flex: 1;
      text-align: center;
    }

    .hero-image img {
      width: 100%;
      max-width: 480px;
      border-radius: 15px;
      box-shadow: var(--shadow);
      transition: transform 0.3s ease;
    }

    .hero-image img:hover {
      transform: scale(1.05);
    }

    /* ===== SECTION TITLE ===== */
    .section-title {
      text-align: center;
      font-size: 2rem;
      margin-top: 80px;
      margin-bottom: 20px;
      position: relative;
    }

    .section-title::after {
      content: "";
      width: 80px;
      height: 4px;
      background-color: var(--primary);
      position: absolute;
      bottom: -10px;
      left: 50%;
      transform: translateX(-50%);
      border-radius: 2px;
    }

    /* ===== MISSION & VISION ===== */
    .mission-vision {
      display: flex;
      flex-wrap: wrap;
      justify-content: center;
      gap: 30px;
      padding: 40px 60px;
      max-width: 1100px;
      margin: 0 auto;
    }

    .mv-card {
      background-color: #fff;
      flex: 1;
      min-width: 320px;
      padding: 40px;
      border-radius: 16px;
      box-shadow: var(--shadow);
      transition: transform 0.3s ease;
      text-align: center;
    }

    .mv-card:hover {
      transform: translateY(-8px);
    }

    .mv-card i {
      font-size: 2.5rem;
      color: var(--primary);
      margin-bottom: 15px;
    }

    .mv-card h3 {
      font-size: 1.4rem;
      margin-bottom: 15px;
      color: var(--dark);
    }

    /* ===== FEATURES ===== */
    .features {
      background-color: #fff;
      padding: 80px 60px;
    }

    .feature-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
      gap: 30px;
      max-width: 1100px;
      margin: 0 auto;
    }

    .feature-card {
      background-color: var(--light);
      padding: 30px 25px;
      border-radius: 15px;
      text-align: center;
      box-shadow: var(--shadow);
      transition: all 0.3s ease;
    }

    .feature-card:hover {
      transform: translateY(-10px);
      background-color: #ffffff;
    }

    .feature-card i {
      font-size: 2.3rem;
      color: var(--primary);
      margin-bottom: 15px;
    }

    .feature-card h3 {
      font-size: 1.2rem;
      margin-bottom: 10px;
    }

    /* ===== FOOTER ===== */
    footer {
      background-color: var(--dark);
      color: #fff;
      text-align: center;
      padding: 20px;
      margin-top: 60px;
      font-size: 0.9rem;
    }

    /* ===== RESPONSIVE ===== */
    @media (max-width: 768px) {
      .hero {
        flex-direction: column;
        text-align: center;
        padding: 70px 30px;
      }

      .hero-text {
        padding-right: 0;
      }

      .mission-vision {
        padding: 30px;
      }

      .features {
        padding: 60px 30px;
      }
    }
  </style>
</head>
<body>

  <!-- NAVBAR -->
  <nav class="navbar">
    <div class="logo">PAY ZEN</div>
    <ul>
      <li><a href="index1.jsp">Dashboard</a></li>
      <li><a href="about.html" class="active">About</a></li>
      <li><a href="contact.html">Contact Us</a></li>
    </ul>
  </nav>

  <!-- HERO SECTION -->
  <section class="hero">
    <div class="hero-text">
      <h1>Empowering Payroll with Precision & Performance</h1>
      <p>Pay Zen is a complete payroll automation solution crafted to simplify workforce management. We combine accuracy, transparency, and technology to ensure every payroll cycle runs flawlessly.</p>
      <a href="contact.html" class="btn">Connect With Us</a>
    </div>
    <div class="hero-image">
      <img src="images/employee.png" alt="Payroll Illustration" />
    </div>
  </section>

  <!-- MISSION & VISION -->
  <h2 class="section-title">Our Mission & Vision</h2>
  <div class="mission-vision">
    <div class="mv-card">
      <i class="fas fa-bullseye"></i>
      <h3>Our Mission</h3>
      <p>To provide businesses with a smart, secure, and scalable payroll management platform that minimizes errors and maximizes productivity.</p>
    </div>
    <div class="mv-card">
      <i class="fas fa-eye"></i>
      <h3>Our Vision</h3>
      <p>To redefine payroll efficiency across industries by making automation accessible, reliable, and empowering for every organization.</p>
    </div>
  </div>

  <!-- FEATURES -->
  <section class="features">
    <h2 class="section-title">Key Features</h2>
    <div class="feature-grid">
      <div class="feature-card">
        <i class="fas fa-robot"></i>
        <h3>Automated Calculations</h3>
        <p>Eliminate human error with intelligent automation for tax, deductions, and overtime.</p>
      </div>
      <div class="feature-card">
        <i class="fas fa-lock"></i>
        <h3>Data Protection</h3>
        <p>Enterprise-grade security and encryption keep sensitive employee data fully safe.</p>
      </div>
      <div class="feature-card">
        <i class="fas fa-chart-bar"></i>
        <h3>Analytics & Reports</h3>
        <p>Track performance, generate detailed reports, and make informed HR decisions.</p>
      </div>
      <div class="feature-card">
        <i class="fas fa-users"></i>
        <h3>Employee Self Service</h3>
        <p>Employees can view payslips, leave status, and tax summaries anytime, anywhere.</p>
      </div>
    </div>
  </section>

  <!-- FOOTER -->
  <footer>
    © 2025 PAY ZEN. All rights reserved. | Designed for professional payroll management.
  </footer>

</body>
</html>
