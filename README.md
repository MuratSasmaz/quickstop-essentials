# QuickStop Essentials

QuickStop Essentials is a simple web application made for our CPAN-228 Web Application Development course.

The main purpose of this project is to create an online store where users can view products, search and filter them, see product details, and add new products to the database.

## Main Features

Our application includes these features:

- Home page
- About page
- Pickup Locations page
- Product list page
- Product details page
- Add Product form
- Form validation
- Search products by name
- Filter products by brand
- Filter products by category
- Sort products by name
- Sort products by price
- Pagination for products
- H2 database
- Sample product data
- Responsive Bootstrap design

## Technologies

We used these technologies in the project:

- Java 21 or newer
- Spring Boot 4.1.0
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Jakarta Validation
- H2 Database
- Bootstrap
- HTML
- CSS
- Maven

## Product Fields

Each product has the following information:

- ID
- Product name
- Description
- Price
- Stock quantity
- Brand
- Category
- Image URL
- Created date and time

## Validation Rules

The Add Product form has server-side validation.

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

| Route | Page |
|---|---|
| `/` | Home page |
| `/about` | About page |
| `/locations` | Pickup Locations page |
| `/products` | Product list |
| `/products/new` | Add Product form |
| `/products/{id}` | Product details |
| `/h2-console` | H2 database console |

## How to Run the Project

### 1. Clone the repository

```bash
git clone https://github.com/MuratSasmaz/quickstop-essentials.git
```

### 2. Open the project folder

```bash
cd quickstop-essentials
```

### 3. Run on Windows

```powershell
.\mvnw.cmd spring-boot:run
```

### 4. Run on macOS or Linux

```bash
./mvnw spring-boot:run
```

### 5. Open the application

Open this address in a browser:

```text
http://localhost:8080
```

## H2 Database

The project uses a file-based H2 database.

To open the H2 console, use:

```text
http://localhost:8080/h2-console
```

Connection information:

```text
JDBC URL: jdbc:h2:file:./data/quickstopdb
User Name: sa
Password:
```

The password should be left empty.

## Sample Products

The project includes 14 sample products in the `data.sql` file.

The products are added when the application starts. Products added from the Add Product form are also saved in the file-based database.

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
- Move between product pages using pagination

The application shows six products on each page.

## Team Contributions

### Murat Sasmaz

- Created the Product entity
- Added validation rules
- Created Brand and Category enums
- Created ProductRepository
- Configured the H2 database
- Added sample products in `data.sql`
- Added the missing Maven Wrapper configuration
- Tested the backend and database
- Managed the GitHub repository
- Reviewed and merged Pull Requests

### Amber Forrest

- Created the first Spring Boot project structure
- Created ProductService
- Created the first ProductController
- Added the main product routes
- Added search, filter, sorting, and pagination logic

### Garv Dugh

- Created the Thymeleaf pages
- Created the Bootstrap design
- Created the Home page
- Created the About page
- Created the Pickup Locations page
- Created the product list page
- Created the Add Product form
- Created the product details page
- Added reusable layout fragments
- Added CSS styling

## Testing

We tested these parts of the application:

- Application startup
- H2 database connection
- Sample product data
- Product list
- Product details
- Add Product form
- Form validation
- Search
- Brand filtering
- Category filtering
- Sorting
- Pagination
- Home page
- About page
- Pickup Locations page

## Course Information

- Course: CPAN-228 Web Application Development
- Project Name: QuickStop Essentials
- Deliverable: Deliverable 1