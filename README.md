# QuickStop Essentials

QuickStop Essentials is a web application that we created for our CPAN-228 Web Application Development course.

The purpose of this project is to create a simple online store where users can view products, search and filter products, and see product details. Staff and admin users can also manage the products.

For Deliverable 2, we added user registration, login, logout, user roles, protected pages, and an admin dashboard.

## Course Information

- Course: CPAN-228 Web Application Development
- Project Name: QuickStop Essentials
- Group: New Group 8
- Deliverable: Final Project Deliverable 2

## Group Members

- Amber Forrest
- Garv Dugh
- Murat Sasmaz

## Main Features

Our application includes the following features:

- Home page
- About page
- Pickup Locations page
- Product list page
- Product details page
- Add Product form
- Edit Product form
- Delete Product function
- Form validation
- Search products by name
- Filter products by brand
- Filter products by category
- Sort products by name
- Sort products by price
- Pagination
- H2 database
- Sample product data
- Responsive Bootstrap design

## Security Features

For Deliverable 2, we added these security features:

- User registration
- Custom login page
- Login error message
- Logout
- BCrypt password encoding
- Duplicate email checking
- Three user roles
- Protected pages
- Different permissions for each role
- Logged-in user shown in the navbar
- Buttons and links shown based on the user role
- Access Denied page
- Admin-only dashboard

## User Roles

The application has three roles:

### CUSTOMER

A customer can:

- View the product list
- Search and filter products
- View product details

A customer cannot add, edit, or delete products.

### STAFF

A staff user can:

- View products
- Add products
- Edit products

A staff user cannot delete products or open the admin dashboard.

### ADMIN

An admin can:

- View products
- Add products
- Edit products
- Delete products
- Open the admin dashboard
- View registered users and their roles

## Role Permissions

| Role | View Products | Add Products | Edit Products | Delete Products | Admin Dashboard |
|---|---:|---:|---:|---:|---:|
| CUSTOMER | Yes | No | No | No | No |
| STAFF | Yes | Yes | Yes | No | No |
| ADMIN | Yes | Yes | Yes | Yes | Yes |

Users who create an account from the registration page automatically receive the `CUSTOMER` role.

## Login and Registration

Users can create an account by entering:

- Full name
- Email address
- Password

The password must contain at least 8 characters.

The application checks whether the email address already exists. If the same email is used again, the user sees an error message.

Passwords are encoded with BCrypt before they are saved in the database.

Users sign in with their email address and password.

## Demo Accounts

The application automatically creates one ADMIN account and one STAFF account.

### Admin Account

```text
Email: admin@quickstop.ca
Password: Admin123!
```

### Staff Account

```text
Email: staff@quickstop.ca
Password: Staff123!
```

These accounts are only used for testing and showing the project.

A new CUSTOMER account can be created from the registration page.

## Admin Dashboard

The admin dashboard shows:

- Total number of users
- Number of staff users
- Number of customer users
- Total number of products
- User names
- User email addresses
- User roles
- Registration dates
- User status

Only a user with the `ADMIN` role can open this page.

## Technologies

We used the following technologies:

- Java 21
- Spring Boot 4.1.0
- Spring MVC
- Spring Data JPA
- Spring Security
- Thymeleaf
- Thymeleaf Spring Security Extras
- Jakarta Validation
- BCrypt
- H2 Database
- Bootstrap 5
- Bootstrap Icons
- HTML
- CSS
- Maven
- Git
- GitHub

## Product Information

Each product has:

- ID
- Product name
- Description
- Price
- Stock quantity
- Brand
- Category
- Image URL
- Created date and time

## Product Validation

The Add Product and Edit Product forms have server-side validation.

The validation rules are:

- Product name is required.
- Product name must be between 2 and 100 characters.
- Description is required.
- Description cannot be more than 500 characters.
- Price must be greater than $0.
- Stock quantity cannot be negative.
- Stock quantity cannot be more than 10,000.
- Brand is required.
- Category is required.
- Image URL is optional.

## Product Categories

The application has four product categories:

- Auto Essentials
- Personal Care
- Tech Essentials
- Basic Clothing

## Brands

The application includes these brands:

- Castrol
- Mobil 1
- Rain-X
- Anker
- Belkin
- Samsung
- Dove
- Colgate
- Nike
- Adidas

## Application Pages

| Route | Page | Access |
|---|---|---|
| `/` | Home page | Public |
| `/about` | About page | Public |
| `/locations` | Pickup Locations page | Public |
| `/register` | Registration page | Public |
| `/login` | Login page | Public |
| `/products` | Product list | CUSTOMER, STAFF, ADMIN |
| `/products/{id}` | Product details | CUSTOMER, STAFF, ADMIN |
| `/products/new` | Add Product form | STAFF, ADMIN |
| `/products/{id}/edit` | Edit Product form | STAFF, ADMIN |
| `/products/{id}/delete` | Delete Product | ADMIN |
| `/admin/dashboard` | Admin dashboard | ADMIN |
| `/access-denied` | Access Denied page | Public |

## Sample Products

The project includes 14 sample products in the `data.sql` file.

The sample products are added when the application starts.

The application checks the product name before adding the sample data. This prevents the same products from being added again every time the project starts.

## Search, Filter, Sort, and Pagination

Users can:

- Search products by product name
- Filter products by brand
- Filter products by category
- Use brand and category filters together
- Sort products by name from A to Z
- Sort products by name from Z to A
- Sort products by price from low to high
- Sort products by price from high to low
- Move between product pages

The application shows six products on each page.

## How to Run the Project

### 1. Clone the repository

```bash
git clone https://github.com/MuratSasmaz/quickstop-essentials.git
```

### 2. Open the project folder

```bash
cd quickstop-essentials
```

### 3. Run the project on Windows

```powershell
.\mvnw.cmd spring-boot:run
```

### 4. Run the project on macOS or Linux

```bash
./mvnw spring-boot:run
```

### 5. Open the application

Open this address in a browser:

```text
http://localhost:8080
```

## Database

The project uses a file-based H2 database.

Database information:

```text
JDBC URL: jdbc:h2:file:./data/quickstopdb
Username: sa
Password: leave empty
```

Products and users are saved in the database.

## How to Run the Tests

### Windows

```powershell
.\mvnw.cmd clean test
```

### macOS or Linux

```bash
./mvnw clean test
```

## Team Contributions

### Amber Forrest

- Added the first Spring Security configuration
- Created the registration backend
- Added BCrypt password encoding
- Created `UserService`
- Created `CustomUserDetailsService`
- Added login and logout settings
- Added protected routes
- Added the first role permission settings
- Tested login and user access

### Garv Dugh

- Created the first login page design
- Created the first registration page design
- Created the Access Denied page design
- Created the Admin Dashboard design
- Added the role-based navbar design
- Added buttons and links based on user roles
- Added Bootstrap styling for the new pages
- Sent the UI files for the final project integration

### Murat Sasmaz

- Managed the project and GitHub repository
- Created the `Role` enum
- Created the `User` entity
- Made the `User` entity implement `UserDetails`
- Created `UserRepository`
- Added sample ADMIN and STAFF accounts
- Created the admin dashboard backend
- Added user and product statistics
- Added product edit functions
- Added product delete functions
- Created the Edit Product page
- Combined Amber’s security work with the main project
- Added and adjusted Garv’s UI work
- Fixed the duplicate email problem
- Fixed the protected route permissions
- Connected the security backend with the HTML pages
- Tested CUSTOMER, STAFF, and ADMIN accounts
- Updated the README
- Completed the final project integration

## Testing

We tested the following parts:

- Application startup
- Maven build
- H2 database connection
- Sample product data
- Registration
- Password encoding
- Duplicate email validation
- Correct login
- Incorrect login
- Login error message
- Logout
- CUSTOMER permissions
- STAFF permissions
- ADMIN permissions
- Protected pages
- Access Denied page
- Role-based navbar
- Add Product
- Edit Product
- Delete Product
- Admin dashboard
- User list
- User roles
- Product statistics
- Search
- Brand filter
- Category filter
- Sorting
- Pagination
- Responsive design

## Test Result

```text
Tests run: 1
Failures: 0
Errors: 0
Skipped: 0
BUILD SUCCESS
```

## Submission

One group member will submit:

- The GitHub repository link
- A short video showing the completed features

The video does not need a voiceover.