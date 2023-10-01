# Minefield
Konsol uzerinden oynatilan mayin tarlasi oyunudur.
Tarla kullanicinin belirledigi satir ve sutun sayisina gore olusturulur.
Mayinlar bu tarla uzerine rastgele noktalara yerlestirilir.
Kullanicin belirledigi nokta acilir. Eger nokta temizse etrafindaki mayin bilgisi verilir. Eger noktada mayin varsa patlar ve oyun biter.

**Dikkat Edilmesi Gerekenler**
- Tarla boyutu en az 2x2 boyutunda olusturulmalidir. Daha kucuk tarlalarda oyun sonlanir.
- Tarla (satir * sutun) / 4 sonucun tamsayi kismi kadar mayin icerir.
- Acilmak istenen nokta tarla sinirlari icerisinde olmalidir. İlk elemanin 0'dan basladigi goz onunde bulundurulmalidir. Hatali giris yapildiginda oyun sonlanmaz. Yeni giris yapilmasi istenir.
