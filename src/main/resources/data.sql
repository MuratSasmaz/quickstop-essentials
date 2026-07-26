-- QuickStop Essentials sample product data

INSERT INTO products
(name, description, price, stock_quantity, brand, category, image_url, created_at)
SELECT
    'Castrol GTX Motor Oil',
    'Reliable motor oil for regular vehicle maintenance and engine protection.',
    34.99,
    18,
    'CASTROL',
    'AUTO_ESSENTIALS',
    'https://placehold.co/600x400?text=Castrol+Motor+Oil',
    CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM products WHERE name = 'Castrol GTX Motor Oil'
);

INSERT INTO products
(name, description, price, stock_quantity, brand, category, image_url, created_at)
SELECT
    'Mobil 1 Synthetic Motor Oil',
    'Full synthetic motor oil designed for strong engine performance.',
    49.99,
    12,
    'MOBIL_1',
    'AUTO_ESSENTIALS',
    'https://placehold.co/600x400?text=Mobil+1+Motor+Oil',
    CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM products WHERE name = 'Mobil 1 Synthetic Motor Oil'
);

INSERT INTO products
(name, description, price, stock_quantity, brand, category, image_url, created_at)
SELECT
    'Rain-X Windshield Washer Fluid',
    'All-season windshield washer fluid for improved visibility while driving.',
    8.99,
    30,
    'RAIN_X',
    'AUTO_ESSENTIALS',
    'https://placehold.co/600x400?text=Washer+Fluid',
    CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM products WHERE name = 'Rain-X Windshield Washer Fluid'
);

INSERT INTO products
(name, description, price, stock_quantity, brand, category, image_url, created_at)
SELECT
    'Anker USB-C Car Charger',
    'Compact car charger with fast USB-C charging for mobile devices.',
    24.99,
    22,
    'ANKER',
    'TECH_ESSENTIALS',
    'https://placehold.co/600x400?text=USB-C+Car+Charger',
    CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM products WHERE name = 'Anker USB-C Car Charger'
);

INSERT INTO products
(name, description, price, stock_quantity, brand, category, image_url, created_at)
SELECT
    'Belkin USB-C Cable',
    'Durable USB-C charging cable for phones, tablets, and other devices.',
    19.99,
    26,
    'BELKIN',
    'TECH_ESSENTIALS',
    'https://placehold.co/600x400?text=USB-C+Cable',
    CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM products WHERE name = 'Belkin USB-C Cable'
);

INSERT INTO products
(name, description, price, stock_quantity, brand, category, image_url, created_at)
SELECT
    'Samsung Portable Power Bank',
    'Portable battery pack for charging mobile devices while travelling.',
    44.99,
    15,
    'SAMSUNG',
    'TECH_ESSENTIALS',
    'https://placehold.co/600x400?text=Power+Bank',
    CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM products WHERE name = 'Samsung Portable Power Bank'
);

INSERT INTO products
(name, description, price, stock_quantity, brand, category, image_url, created_at)
SELECT
    'Samsung Wireless Earbuds',
    'Compact wireless earbuds for music, calls, and daily commuting.',
    89.99,
    9,
    'SAMSUNG',
    'TECH_ESSENTIALS',
    'https://placehold.co/600x400?text=Wireless+Earbuds',
    CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM products WHERE name = 'Samsung Wireless Earbuds'
);

INSERT INTO products
(name, description, price, stock_quantity, brand, category, image_url, created_at)
SELECT
    'Dove Deodorant',
    'Daily-use deodorant that provides long-lasting freshness.',
    7.49,
    35,
    'DOVE',
    'PERSONAL_CARE',
    'https://placehold.co/600x400?text=Dove+Deodorant',
    CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM products WHERE name = 'Dove Deodorant'
);

INSERT INTO products
(name, description, price, stock_quantity, brand, category, image_url, created_at)
SELECT
    'Dove Daily Moisture Shampoo',
    'Moisturizing shampoo made for regular hair care and cleaning.',
    9.99,
    21,
    'DOVE',
    'PERSONAL_CARE',
    'https://placehold.co/600x400?text=Dove+Shampoo',
    CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM products WHERE name = 'Dove Daily Moisture Shampoo'
);

INSERT INTO products
(name, description, price, stock_quantity, brand, category, image_url, created_at)
SELECT
    'Colgate Total Toothpaste',
    'Everyday toothpaste for cleaning teeth and maintaining fresh breath.',
    5.99,
    40,
    'COLGATE',
    'PERSONAL_CARE',
    'https://placehold.co/600x400?text=Colgate+Toothpaste',
    CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM products WHERE name = 'Colgate Total Toothpaste'
);

INSERT INTO products
(name, description, price, stock_quantity, brand, category, image_url, created_at)
SELECT
    'Nike Everyday Socks',
    'Comfortable everyday socks suitable for work, school, or travel.',
    17.99,
    20,
    'NIKE',
    'BASIC_CLOTHING',
    'https://placehold.co/600x400?text=Nike+Socks',
    CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM products WHERE name = 'Nike Everyday Socks'
);

INSERT INTO products
(name, description, price, stock_quantity, brand, category, image_url, created_at)
SELECT
    'Adidas Basic T-Shirt',
    'Simple and comfortable short-sleeve shirt for everyday use.',
    29.99,
    14,
    'ADIDAS',
    'BASIC_CLOTHING',
    'https://placehold.co/600x400?text=Adidas+T-Shirt',
    CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM products WHERE name = 'Adidas Basic T-Shirt'
);

INSERT INTO products
(name, description, price, stock_quantity, brand, category, image_url, created_at)
SELECT
    'Nike Pullover Hoodie',
    'Warm pullover hoodie for cool weather and casual daily use.',
    64.99,
    11,
    'NIKE',
    'BASIC_CLOTHING',
    'https://placehold.co/600x400?text=Nike+Hoodie',
    CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM products WHERE name = 'Nike Pullover Hoodie'
);

INSERT INTO products
(name, description, price, stock_quantity, brand, category, image_url, created_at)
SELECT
    'Adidas Winter Gloves',
    'Warm gloves for commuting, outdoor activities, and winter travel.',
    24.99,
    16,
    'ADIDAS',
    'BASIC_CLOTHING',
    'https://placehold.co/600x400?text=Winter+Gloves',
    CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM products WHERE name = 'Adidas Winter Gloves'
);