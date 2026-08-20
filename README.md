# EventHive - Event Booking System

A full-featured event booking web app built with **PHP + MySQL + HTML/CSS/JavaScript**.
Tested end-to-end (register → login → book → pay → cancel, and full admin CRUD) before delivery.

## Features
- User registration & login (bcrypt password hashing, sessions)
- Browse/search/filter events by category
- Event details with **multiple time slots**, live seat availability
- Book a slot, choose number of seats, live price calculation
- **Mock payment** flow (Card / UPI / Netbanking) — no real gateway, safe for demos
- Booking confirmation page with a unique booking code
- User dashboard: stats + recent bookings
- My Bookings page: cancel a booking (seats are released back automatically)
- Admin dashboard: revenue, bookings, events, users stats
- Admin: create/edit/delete events with dynamic multi-slot forms
- Admin: view/filter all bookings
- Admin: block/unblock users

## Setup (XAMPP / WAMP)

1. Copy the `event-booking` folder into your `htdocs` (XAMPP) or `www` (WAMP) directory.
2. Start Apache and MySQL from the XAMPP/WAMP control panel.
3. Open **phpMyAdmin** (`http://localhost/phpmyadmin`) → click **Import** → choose
   `database/event_booking.sql` → Go. This creates the `event_booking` database,
   tables, one admin account, and 3 sample events with slots.
4. Visit `http://localhost/event-booking/` in your browser.

### Default admin login
```
Email:    admin@events.com
Password: admin123
```

### Database config
If your MySQL username/password differ from the XAMPP/WAMP default (`root` / no password),
edit `config/db.php`:
```php
$DB_HOST = "localhost";
$DB_USER = "root";
$DB_PASS = "";
$DB_NAME = "event_booking";
```

## Folder structure
```
event-booking/
├── admin/              # Admin panel (dashboard, manage events/bookings/users)
├── user/               # User dashboard + bookings
├── config/db.php        # DB connection
├── includes/            # auth.php (session/helpers), header.php, footer.php
├── assets/css/style.css
├── assets/js/script.js
├── database/event_booking.sql
├── index.php, events.php, event-details.php
├── login.php, register.php, logout.php
├── book-event.php, payment.php, booking-success.php, cancel-booking.php
```

## Notes on the mock payment
Since this is a demo project, `payment.php` doesn't call any real payment gateway.
It validates the form fields look plausible, then marks the booking as `confirmed`
and generates a fake transaction ID. To add a real gateway later (e.g. Razorpay/Stripe
test mode), that logic would slot into the `if (empty($errors))` block in `payment.php`.

## Things you can extend
- Email confirmation on booking (PHPMailer)
- QR code on the booking confirmation (ticket scanning)
- Image upload for events (currently uses emoji placeholders)
- Reviews/ratings per event
- Auto-expire unpaid "pending" bookings after N minutes (a cron job or scheduled check)
