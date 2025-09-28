# Purchase Order Application

## Index

- [Deskripsi](#deskripsi)
- [Struktur Project](#struktur-project)
- [Schema Database](#schema-database)
- [Fitur](#fitur)
  - [Enpoint](#enpoint)
    - [Endpoint Create User](#endpoint-create-user)
    - [Endpoint Read User](#endpoint-read-user)
    - [Endpoint Update User](#endpoint-upadate-user)
    - [Endpoint Delete User](#endpoint-delete-user)
    - [Endpoint Create Item](#endpoint-create-item)
    - [Endpoint Read Item](#endpoint-read-item)
    - [Endpoint Update Item](#endpoint-upadate-item)
    - [Endpoint Delete Item](#endpoint-delete-item)
    - [Endpoint Create Pruchase Order](#endpoint-create-pruchase-order)
    - [Endpoint Read Pruchase Order](#endpoint-read-pruchase-order)
    - [Endpoint Update Pruchase Order](#endpoint-upadate-pruchase-order)
    - [Endpoint Delete Pruchase Order](#endpoint-delete-pruchase-order)
- [Cara Menggunakan](#cara-menggunakan)
  - [Persiapan PostgreSQL](#persiapan-postgres)
  - [Test](#test)
  - [Package](#package)
  - [Run](#run)
- [Kontak](#kontak)

## Deskripsi

Project ini menggunakan spring-boot versi 3.5.6 sebagai backend dari pruchase order. Untuk database yang digunakan pada project atau aplikasi ini adalah PostgreSQL. Pada project bertujuan untuk menunjukan penggunaan spring-boot untuk CRUD (Create Read Update Delete). Project ini tidak menggunakan filter chain atau spring scurity, untuk menjaga scope pengerjaan. Sehingga endpoint yang tersedia dapat langsung di hit tanpa authenticate pengguna. CRUD yang dibuat pada project ini antara lain:

- CRUD user (berisikan operasi yang berhubungan dengan tabel user).
- CRUD item (berisikan operasi yang berhubungan dengan tabel item).
- CRUD purchase order (berisikan operasi yang berhubungan dengan tabel purchase order header dan detail).

Pada root directory project terdapat file postman berisikan collection untuk masih masing endpoint dengan total 15 endpoint dan contoh hasil sukses maupun errornya. Untuk list endpoint secara lengkap dengan aturan yang dibuat dapat dilihat pada bagian [Enpoint](#enpoint).

Pada project ini juga ditambahkan unit testing untuk menjaga kualitas dari pada code. Untuk mengukur tingkat coverage digunakan library Jacoco. Untuk mengcek hasil dari Jacoco dapat dilihat pada bagian [Test](#test) dibawah ini. Pada hasil yang didapatkan tanpa menggunakan exclude package seperti DTO / Models dan Constants, mendapatkan hasil lebih dari 80% coverage. Sedangkan dengan exclude package Models dan Constants, mendapatkan hasil lebih dari 90%. Tujuan dari di exclude package atau semua code pada package tersebut karena tujuan dari class yang dipackage tersebut bersifat non-logic.

## Struktur Project

Berikut ini adalah struktur project yang dibuat:

```
.
├── src/
│   ├── main/
│   │   ├── java/kielvien/lourensius/eka/setia/putra/boostbank/purchaseorder/
│   │   │   ├── PurchaseorderApplication.java
│   │   │   ├── Configurations/
│   │   │   │   └── LoggerAspect.java
│   │   │   ├── Constants/
│   │   │   │   └── Constants.java
│   │   │   ├── Controller/
│   │   |   |   ├── ItemController.java
│   │   |   |   ├── PurchaseOrderController.java
│   │   |   |   ├── RestErrorController.java
│   │   │   │   └── UserController.java
│   │   │   ├── Entities/
│   │   |   |   ├── AuditTrail.java
│   │   |   |   ├── Item.java
│   │   |   |   ├── PurchaseOrderDetail.java
│   │   |   |   ├── PurchaseOrderHeader.java
│   │   │   │   └── User.java
│   │   │   ├── Models/
│   │   |   |   ├── CreateItemRequest.java
│   │   |   |   ├── CreateItemResponse.java
│   │   |   |   ├── CreatePurchaseOrderRequest.java
│   │   |   |   ├── CreatePurchaseOrderResponse.java
│   │   |   |   ├── CreateUserRequest.java
│   │   |   |   ├── CreateUserResponse.java
│   │   |   |   ├── GetItemResponse.java
│   │   |   |   ├── GetPurchaseOrderResponse.java
│   │   |   |   ├── GetUserResponse.java
│   │   |   |   ├── PurchaseOrderDetailModel.java
│   │   |   |   ├── UpdateItemRequest.java
│   │   |   |   ├── UpdateItemResponse.java
│   │   |   |   ├── UpdatePurchaseOrderResponse.java
│   │   |   |   ├── UpdatePurchaseOrderResponse.java
│   │   |   |   ├── UpdateUserResponse.java
│   │   |   |   ├── UpdateUserResponse.java
│   │   |   |   ├── WebPageResponse.java
│   │   │   │   └── WebResponse.java
│   │   │   ├── Repository/
│   │   |   |   ├── ItemRepository.java
│   │   |   |   ├── PurchaseOrderHeaderRepository.java
│   │   │   │   └── UserRepository.java
│   │   │   └── Services/
│   │   |       ├── ItemService.java
│   │   |       ├── PurchaseOrderService.java
│   │   |       ├── UserService.java
│   │   │       └── ValidationService.java
│   │   └── resource/
│   │           ├── schema.sql
│   │           ├── data.sql
│   │           ├── application.properties
│   │           └── application-dev.properties
│   └── test/
│       └── java/kielvien/lourensius/eka/setia/putra/boostbank/purchaseorder
│           ├── PurchaseorderApplicationTests.java
│           ├── constants/
|           |   └── ConstantsDataTest.java
│           ├── controllers/
│           |   ├── ItemControllerTest.java
│           |   ├── PurchaseOrderControllerTest.java
│           |   └── UserControllerTest.java
│           └── repository/
|               └── AuditTrailTest
├── pom.xml
├── Kielvien Lourensius Eka Setia Putra.postman_collection.json
└── README.md
```

Pada struktur project diatas berikut ini penjelasannya :

- Package configurations berisikan configurasi spring-boot, disini diisi dengan class Aspect untuk digunakan menampilkan log saat keluar masuk method.
- Package constants berisikan variabel yang bersifat constant dan enum.
- Package controller berisikan endpoint CRUD untuk user, item, dan purchase order.
- Package entities berisikan object mapping ke database.
- Package models berisikan object mapping request dan response untuk endpoint atau object yang diperlukan untuk proses logic.
- Package repository berisikan layer interface yang digunakan untuk mengakses database.
- Package services berisikan logic untuk menyimpan, update, delete, dan mengambil data yang diteruskan ke layer repository.
- Folder resource berisikan properties file untuk configurasi aplikasi dan berisikan schema dan data seed.
- Package constants dalam folder test berisikan constant yang digunakan pada unit test.
- Package controllers dalam folder test berisikan unit test dengan endpoint untuk mengecek logic code.
- Package repository dalam folder test berisikan unit test khusus untuk repository untuk mengecek logic code.

Pada bagian root folder berisikan pom.xml, readme.md, dan collection postman.

## Schema Database

Berikut ini adalah schema database untuk table:

Tabel **_users_**  
Tabel user memiliki primary key id dengan jenis squeance.

|     Kolom Name     |  Tipe Data   | Null Value |
| :----------------: | :----------: | :--------: |
|        `id`        |   Integer    |     No     |
|    `first_name`    | Varchar(500) |     No     |
|    `last_name`     | Varchar(500) |     No     |
|      `email`       |   Varchar    |     No     |
|      `phone`       |   Varchar    |     No     |
|    `created_by`    |   Varchar    |     No     |
| `created_datetime` |  Timestamp   |     No     |
|    `updated_by`    |   Varchar    |    Yes     |
| `updated_datetime` |  Timestamp   |    Yes     |

Tabel **_items_**  
Tabel items memiliki primary key id dengan jenis squeance.

|     Kolom Name     |  Tipe Data   | Null Value |
| :----------------: | :----------: | :--------: |
|        `id`        |   Integer    |     No     |
|       `name`       |   Varchar    |     No     |
|   `description`    | Varchar(500) |     No     |
|      `price`       |   Integer    |     No     |
|       `cost`       |   Integer    |     No     |
|    `created_by`    |   Varchar    |     No     |
| `created_datetime` |  Timestamp   |     No     |
|    `updated_by`    |   Varchar    |    Yes     |
| `updated_datetime` |  Timestamp   |    Yes     |

Tabel **_po_h_**  
Tabel po_h memiliki primary key id dengan jenis squeance. Tabel ini memiliki relasi one to many dengan po_d. Dimana 1 data po_h dapat memiliki banyak po_d. Nilai datetime ketika pertama kali dibuat akan diisi dengan nilai time pada sisitem operasi. Sedangkan untuk total price dan total cost, nilai akan terisi otomatis dengan perhitungan dari pada total jumlah item cost dan item price.

|     Kolom Name     |  Tipe Data   | Null Value |
| :----------------: | :----------: | :--------: |
|        `id`        |   Integer    |     No     |
|     `dateTime`     |  Timestamp   |     No     |
|    `desciption`    | Varchar(500) |     No     |
|   `total_price`    |   Integer    |     No     |
|    `total_cost`    |   Integer    |     No     |
|    `created_by`    |   Varchar    |     No     |
| `created_datetime` |  Timestamp   |     No     |
|    `updated_by`    |   Varchar    |    Yes     |
| `updated_datetime` |  Timestamp   |    Yes     |

Tabel **_po_d_**  
Tabel po_d memiliki primary key id dengan jenis squeance. Tabel ini bereleasi dengan tabel po_h dengan foreign key pada tabel po_h diisi pada poh_id. Pada nilai item cost dan item price akan otomatis terisi berdasarkan item qty dikali dengan price dan cost pada tabel item. Pada project ini total qty dibuat tidak boleh berjumlah 0 atau minimum harus 1.

|     Kolom Name     | Tipe Data | Null Value |
| :----------------: | :-------: | :--------: |
|        `id`        |  Integer  |     No     |
|      `poh_id`      |  Integer  |     No     |
|     `item_id`      |  Integer  |     No     |
|     `item_qty`     |  Integer  |     No     |
|    `item_cost`     |  Integer  |     No     |
|    `item_price`    |  Integer  |     No     |
|    `created_by`    |  Varchar  |     No     |
| `created_datetime` | Timestamp |     No     |
|    `updated_by`    |  Varchar  |    Yes     |
| `updated_datetime` | Timestamp |    Yes     |

Pada tiap tabel diatas, untuk field created by dan created datetime akan otomatis dibuat saat pembuatan data. Sedangkan untuk updated by dan updated datetime akan otomatis terisi ketika dilakukan operasi update data.

**_Note_** : Karena project ini tidak menggunakan authenticate untuk menjaga scope pengerjaan maka created by dan updated by akan otomati terisi SYSTEM.

## Fitur

Project ini menggunakan spring-boot dengan fitur restfull API untuk mengangani CRUD operasi user, item, dan pruchase order (po_h dan po_d). Selain itu digunakan fitur aspect untuk melakukan logging pada aplikasi dan untuk handle error pada aplikasi saat berjalan. Fitur lain yang digunakan pada project ini adalah JPA untuk mengelola akses ke database.

### Enpoint

Berikut ini adalah detail spesifikasi dari endpoint dan contohnya:

**_Note:_** dapat juga dilihat pada collection postman.

#### Endpoint Create User

Endpoint ini digunakan untuk menyimpan data user, terdapat request body sebagai berikut.

- firstName berisikan String dengan maksimum character 500, first name tidak boleh kosong atau tidak ada.
- lastName berisikan String dengan maksimum character 500, last name tidak boleh kosong atau tidak ada.
- email berisikan String dengan pattern email dimana harus memiliki @ dan domain name, email tidak boleh kosong atau tidak ada.
- phone harus berisikan tipe string dengan isi berupa angka dan total tidak lebih dari 12. Untuk pola penulisan dapat menggunakan +62 atau 62 atau 0 untuk angka depan. phone tidak boleh kosong atau tidak ada.

```
endpoint : /api/user/create
request:
{
  "firstName":"Kielvien",
  "lastName":"Lourensius Eka Setia Putra",
  "email":"kielvien@gmail.com",
  "phone":"085888888888"
}

response:
{
    "data": {
        "id": 41,
        "firstName": "Kielvien",
        "lastName": "Lourensius Eka Setia Putra",
        "phone": "085888888888",
        "email": "kielvien@gmail.com"
    },
    "statusCode": "00",
    "desc": "SUCCESS"
}
```

#### Endpoint Read User

Pada endpoint get user terdapat 2 yaitu untuk spesifik by id dan get all data. Untuk spesifik menggunakan parameter path. Sedangkan untuk get all menggunakan param page untuk halaman yang ingin dilihat dan pageSize untuk jumlah tiap halaman data (offset dan limit). Default dari param page adalah 0 dan pageSize 10 kalau tidak diberikan.

```
endpoint : /api/user/finduser
request param
page : 0
pageSize: 10

response:
{
    "data": [
        {
            "id": 1,
            "firstName": "person1",
            "lastName": "last human",
            "phone": "08888888881",
            "email": "person1@gmail.com"
        },
        {
            "id": 2,
            "firstName": "person2",
            "lastName": "last human",
            "phone": "08888888882",
            "email": "person2@gmail.com"
        }
    ],
    "statusCode": "00",
    "desc": "SUCCESS",
    "paging": {
        "currentPage": 0,
        "totalPage": 20,
        "size": 2
    }
}


endpoint : /api/user/finduser/{user id}
response:
{
    "data": {
        "id": 1,
        "firstName": "person1",
        "lastName": "last human",
        "phone": "08888888881",
        "email": "person1@gmail.com"
    },
    "statusCode": "00",
    "desc": "SUCCESS"
}
```

#### Endpoint Update User

Endpoint ini digunakan untuk mengupdate data user, terdapat request body dengnan path parameter dengan jenis angka untuk id data yang akan diupdate. berikut ini penjelasan.

- firstName berisikan String dengan maksimum character 500, first name tidak boleh kosong atau tidak ada.
- lastName berisikan String dengan maksimum character 500, last name tidak boleh kosong atau tidak ada.
- email berisikan String dengan pattern email dimana harus memiliki @ dan domain name, email tidak boleh kosong atau tidak ada.
- phone harus berisikan tipe string dengan isi berupa angka dan total tidak lebih dari 12. Untuk pola penulisan dapat menggunakan +62 atau 62 atau 0 untuk angka depan. phone tidak boleh kosong atau tidak ada.

```
endpoint : /api/user/update/1
request:
{
    "firstName":"Kielvien update",
    "lastName":"Lourensius Eka Setia Putra Update",
    "email":"kielvienupdate@gmail.com",
    "phone":"085118888888"
}

response:
{
    "data": {
        "firstName": "Kielvien update",
        "lastName": "Lourensius Eka Setia Putra Update",
        "phone": "085118888888",
        "email": "kielvienupdate@gmail.com"
    },
    "statusCode": "00",
    "desc": "SUCCESS"
}
```

#### Endpoint Delete User

Untuk menghapus data dari user digunakan endpoint delete dengan parameter yang diberikan pada akhir path dengan jenis angka id data yang ingin dihapus.

```
endpoint : api/user/delete/10
response:
{
    "data": 10,
    "statusCode": "00",
    "desc": "SUCCESS"
}
```

#### Endpoint Create Item

Endpoint ini digunaka untuk menyimpan data user, terdapat request body sebagai berikut.

- nama berisikan string dengan total maksimal character 500, tidak dapat kosong atau tidak ada.
- description berisikan string dengan total maksimal character 500, tidak dapat kosong atau tidak ada.
- price berisikan nominal angka dengan ketentuan tidak boleh 0.
- cost berisikan nominal angka dengan ketentuan tidak boleh 0.

```
endpoint : /api/item/create
request:
{
    "name":"barang dummy" ,
    "description":"barang dummy testing",
    "price":3000,
    "cost":400
}

response:
{
    "data": {
        "id": 41,
        "name": "barang dummy",
        "description": "barang dummy testing",
        "price": 3000,
        "cost": 400
    },
    "statusCode": "00",
    "desc": "SUCCESS"
}
```

#### Endpoint Read Item

Pada endpoint get item terdapat 2 yaitu untuk spesifik by id dan get all data. Untuk spesifik menggunakan parameter path. Sedangkan untuk get all menggunakan param page untuk halaman yang ingin dilihat dan pageSize untuk jumlah tiap halaman data (offset dan limit). Default dari param page adalah 0 dan pageSize 10 kalau tidak diberikan.

```
endpoint : /api/item/finditem
request param
page : 0
page Size : 2

response:
{
    "data": [
        {
            "id": 2,
            "name": "Barang2",
            "description": "Deskripsi Barang 2",
            "price": 2000,
            "cost": 1000
        },
        {
            "id": 3,
            "name": "Barang3",
            "description": "Deskripsi Barang 3",
            "price": 3000,
            "cost": 1500
        }
    ],
    "statusCode": "00",
    "desc": "SUCCESS",
    "paging": {
        "currentPage": 0,
        "totalPage": 21,
        "size": 2
    }
}

endpoint : /api/item/finditem/1
response:
{
    "data": {
        "id": 1,
        "name": "barang dummy update",
        "description": "barang dummy testing update",
        "price": 30000,
        "cost": 700
    },
    "statusCode": "00",
    "desc": "SUCCESS"
}
```

#### Endpoint Update Item

Endpoint ini digunakan untuk mengupdate data item, terdapat request body dengnan path parameter dengan jenis angka untuk id data yang akan diupdate. berikut ini penjelasan pathnya

- nama berisikan string dengan total maksimal character 500, tidak dapat kosong atau tidak ada.
- description berisikan string dengan total maksimal character 500, tidak dapat kosong atau tidak ada.
- price berisikan nominal angka dengan ketentuan tidak boleh 0.
- cost berisikan nominal angka dengan ketentuan tidak boleh 0.

```
endpoint : /api/item/update/1
request:
{
    "name":"barang dummy update" ,
    "description":"barang dummy testing update",
    "price":30000,
    "cost":700
}

response:
{
    "data": {
        "name": "barang dummy update",
        "description": "barang dummy testing update",
        "price": 30000,
        "cost": 700
    },
    "statusCode": "00",
    "desc": "SUCCESS"
}
```

#### Endpoint Delete Item

Untuk menghapus data dari item digunakan endpoint delete dengan parameter yang diberikan pada akhir path dengan jenis angka id data yang ingin dihapus.

```
endpoint : /api/item/delete/10
response:
{
    "data": 10,
    "statusCode": "00",
    "desc": "SUCCESS"
}
```

#### Endpoint Create Pruchase Order

Endpoint ini bertujuan untuk menyimpan data pruchase order dimana berikut dibawah ini adalah penjelasannya:

- description berisikan String dengan total karakter tidak lebih dari 500, dan tidak boleh kosong atau tidak ada.
- puchase order detail berisikan array atau list dari pada item id yang akan digunakan dan harus ada di data tabel item, serta item qty unutk jumlah.

```
endpoint : /api/po/create
request:
{
    "description": "Description Transaction Dummy 1",
    "purchaseOrderDetails": [
        {
            "itemId": 1,
            "itemQty": 5
        }
    ]
}

response:
{
    "data": {
        "id": 41,
        "description": "Description Transaction Dummy 1",
        "dateTime": "2025-09-28T22:48:22.1305212",
        "totalPrice": 150000,
        "totalCost": 3500,
        "purchaseOrderDetails": [
            {
                "id": 41,
                "itemId": 1,
                "itemQty": 5,
                "itemCost": 150000,
                "itemPrice": 3500
            }
        ]
    },
    "statusCode": "00",
    "desc": "SUCCESS"
}
```

#### Endpoint Read Pruchase Order

Pada endpoint get purhcase order terdapat 2 yaitu untuk spesifik by id dan get all data. Untuk spesifik menggunakan parameter path. Sedangkan untuk get all menggunakan param page untuk halaman yang ingin dilihat dan pageSize untuk jumlah tiap halaman data (offset dan limit). Default dari param page adalah 0 dan pageSize 10 kalau tidak diberikan.

```
endpoint : /api/po/findPurchaseOrder
request param
page : 0
page Size : 2

response:
{
    "data": [
        {
            "id": 1,
            "description": "Transaksi 1",
            "dateTime": "2025-09-28T22:35:50.467573",
            "totalPrice": 1000,
            "totalCost": 500,
            "purchaseOrderDetails": [
                {
                    "id": 1,
                    "itemId": 1,
                    "itemQty": 1,
                    "itemCost": 500,
                    "itemPrice": 1000
                }
            ]
        },
        {
            "id": 2,
            "description": "Transaksi 2",
            "dateTime": "2025-09-28T22:35:50.469345",
            "totalPrice": 2000,
            "totalCost": 1000,
            "purchaseOrderDetails": [
                {
                    "id": 2,
                    "itemId": 2,
                    "itemQty": 1,
                    "itemCost": 1000,
                    "itemPrice": 2000
                }
            ]
        }
    ],
    "statusCode": "00",
    "desc": "SUCCESS",
    "paging": {
        "currentPage": 0,
        "totalPage": 21,
        "size": 2
    }
}

endpoint : /api/po/findPurchaseOrder/4
response:
{
    "data": {
        "id": 4,
        "description": "Transaksi 4",
        "dateTime": "2025-09-28T22:35:50.472663",
        "totalPrice": 4000,
        "totalCost": 2000,
        "purchaseOrderDetails": [
            {
                "id": 4,
                "itemId": 4,
                "itemQty": 1,
                "itemCost": 2000,
                "itemPrice": 4000
            }
        ]
    },
    "statusCode": "00",
    "desc": "SUCCESS"
}

```

#### Endpoint Update Pruchase Order

Endpoint ini bertujuan untuk mengupdate data pruchase order dimana berikut dibawah ini adalah penjelasannya:

- description berisikan String dengan total karakter tidak lebih dari 500, dan tidak boleh kosong atau tidak ada.
- datetime berisikan waktu, harus diisi.
- purchase order detail berisikan array atau list dari pada item id yang akan digunakan dan harus ada di data tabel item, serta item qty unutk jumlah.

Pada endpoint ini data pada detail tidak dapat diganti berkurang atau diperbanyak tetapi dapat diupdate sesuai atau cuman sebagian. Hal ini untuk menjaga integritas data antara tabel header dan tabel detail.

```
endpoint : /api/po/updatePurchaseOrder/4
request:
{
    "description": "Transaksi 4 update",
    "dateTime": "2025-09-30T00:00:00",
    "purchaseOrderDetails": [
        {
            "id": 4,
            "itemId": 4,
            "itemQty": 5
        }
    ]
}

response:
{
    "data": {
        "description": "Transaksi 4 update",
        "dateTime": "2025-09-30T00:00:00",
        "totalPrice": 20000,
        "totalCost": 10000,
        "purchaseOrderDetails": [
            {
                "itemId": 4,
                "itemQty": 4,
                "itemCost": 10000,
                "itemPrice": 20000
            }
        ]
    },
    "statusCode": "00",
    "desc": "SUCCESS"
}
```

#### Endpoint Delete Pruchase Order

Untuk menghapus data dari purchase order digunakan endpoint delete dengan parameter yang diberikan pada akhir path dengan jenis angka id data yang ingin dihapus.

```
endpoint : /api/po/deletePurchaseOrder/10
response:
{
    "data": 10,
    "statusCode": "00",
    "desc": "SUCCESS"
}
```

## Cara Menggunakan

Berikut ini adalah cara penggunaan untuk menjadikan package jar, menjalankan test, serta menjalankan project pada enviroment window.

hal yang perlu disiapkan antara sebelum menjalankan antara lain:

- JDK versi ke 21.
- PostgreSQL.

### Persiapan PostgreSQL

Untuk persiapan database dengan menggunakan PostgreSQL, script ada pada file scriptSQL.sql di root folder. Berikut ini tahapannya menggunakan terminal:

- Jalankan PostgreSQL dan masuk ke PostgreSQL dangan printah dibawah ini.

```
psql -U postgres
```

- Kemudian setelah masukan perintah berikut ini, untuk membuat user bernama kielvien12345 dengna password boostbank12345.

```
CREATE USER kielvien12345 WITH PASSWORD 'boostbank12345';
```

- Masukan perintah berikut dibawah ini, untuk membuat database dangan status kepemiliki user kielvien12345.

```
CREATE DATABASE kielvien_lourensius_esp owner kielvien12345;
```

- Untuk mengecek apakah sudah terbuat user pada PostgreSQL, bisa dengna mengetik printah dibawah ini.

```
\du
```

- Masukan perintah berikut dibawah ini, untuk memberikan akses privilage database kepada user kielvien12345.

```
GRANT ALL PRIVILEGES ON DATABASE kielvien_lourensius_esp TO kielvien12345;
```

- Kemudian setelah dibuat masuk ke database dengan perintah dibawah ini.

```
\c kielvien_lourensius_esp
```

- Kemudian berikan lagi akses akses privilage ke table dan squences.

```
GRANT ALL PRIVILEGES ON DATABASE kielvien_lourensius_esp TO kielvien12345;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO kielvien12345;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO kielvien12345;
```

Pada tahapan ini proses untuk persiapan PostgreSQL telah selesai, untuk tabel dan seed data awal berada pada folder resource dengan file schema.sql untuk create tabel dan data.sql untuk dummy data awal. Pembuatan tabel akan otomatis dibuat pada environment dev pada settingan applicaiton-dev.properties saat dijalankan.

**_Note:_** untuk env dev sql yang ada pada data akan di truncade datanya dan di restart indexnya ke angka 1 setiap kali running aplikasi project.

### Test

Untuk melakukan pengujian unit test pada project dapat dilakukan dengan mengetik perintah berikut ini pada bagian bawah di terminal.

```
mvn test
```

Apabila inging spesifik pada endpoint tertentu dapat dilakukan dengan berikut dibawah ini. Sebagai contoh create user secara sukses pada class user controller test di subclass create user.

```
mvn test -Dtest=UserControllerTest$createUserTest#successCreate
```

### Package

Untuk membuat package project menjadi jar file maka dapat diketikan melalui perintah dibawah ini. Dimana perintah ini akan menghapus folder target dan membuat folder target ulang dengan isi file Jacoco dan file Jar.

```
mvn clean package
```

### Run

Untuk menjalankan aplikasi kita dapat memilih settingan environment melalui properties file, secara default akan dev. Untuk production level tidak akan generete data dan schema tabel pada database tetapi hanya dilakukan validasi.
Berikut ini perintah untuk menjalankan project spring-boot

```
mvn spring-boot:run
```

Untuk mencoba endpoint yang telah dijalankan silahkan untuk import file Kielvien Lourensius Eka Setia Putra.postman_collection.json pada postman. Untuk persiapan postman silahkan buka dan isi base_url pada variables dengan localhost:8080 atau kalau diganti port pada properties file mengikut port tersebut.

## Kontak

Untuk konsultasi dan pertannyaan lebih lanjut, silahkan menghubungi kontak dibawah ini.

Nama : Kielvien lourensius Eka Setia Putra  
Email : for2university@gmail.com
