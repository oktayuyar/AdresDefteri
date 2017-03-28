# AdresDefteri
JSF, JPA, Maven teknolojilerini kullanarak yapacağım basit bir adres defteri web uygulaması

Gereksinimler:

- Java Version 1.8.0

- Dynamic Web Module 3.0

- JavaServer Faces v2.0 

- Apache Tomcat-8.0.32

- Hibernate 5.2.6

- MySql Server  5.5

İlk kurulum ve çalıştırma aşamasında dikkat edilmesi gerekenler:

*** Program maven projesi olarak geliştirildi.Programı ilk açtığınızda java sınıflarında hata alıyorsanız gerekli kütüphaneler sizin bilgisayarınızda bulunmamaktadır.Bu sorunu çözmek için projenin üstüne gelip sağ tık yapıp Maven -> Update Project e tıklayınız. Offline seçeneğine tik atarak Ok deyiniz.İnternet bağlantınız bulunuyorsa jar dosyaları internetten indirilecektir.

*** Uzun yoldan yapmak isteseniz GNU/Linuz üzerinde /home/bilgisayarın adı/.m2/repository klasörüne giriniz ve içerisine kütüphaneleri ekleyiniz.

*** Programı ilk çalıştırdığınızda NullPointerException hatası almanız muhtemel olacaktır.Bunun sebebi program çalıştığında kayıtlı kişileri listeleme fonksiyonu otomatik olarak çalışmaktadır.Ancak veritabanımızda veri bulunmadığı için bu hatayı alacağız.Öncelikle veritabanını indirip kurmanızı öneriyorum.


# Anasayfa
![png](https://github.com/oktayuyar/AdresDefteri/blob/master/images/index.png "Anasayfa")

# Detay Sayfası
![png](https://github.com/oktayuyar/AdresDefteri/blob/master/images/detay.png "Kişi Detay Sayfası")
