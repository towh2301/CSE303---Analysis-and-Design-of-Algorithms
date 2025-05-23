Dưới đây là **ghi chú Markdown hoàn chỉnh** về thuật toán **Exponentiation by Squaring (Lũy thừa nhị phân)** và cách áp dụng vào bài toán Power Mod bằng Java:

---

````markdown
# 🔢 Exponentiation by Squaring (Lũy thừa nhị phân)

## 📌 Mục tiêu
Tính nhanh giá trị `x^n % k` với:
- `x`: cơ số
- `n`: số mũ (rất lớn, có thể tới 10^18)
- `k`: số chia (mod)

---

## ❌ Cách tính lũy thừa thông thường (O(n))

```java
long result = 1;
for (long i = 0; i < n; i++) {
    result *= x;
}
````

* Không hiệu quả với `n` lớn (ví dụ: $10^{18}$)
* Dễ gây tràn số (overflow)

---

## ✅ Ý tưởng: Exponentiation by Squaring (O(log n))

Chia nhỏ bài toán theo kiểu nhị phân:

| Trường hợp | Công thức             |
| ---------- | --------------------- |
| `n` chẵn   | `x^n = (x^(n/2))^2`   |
| `n` lẻ     | `x^n = x * (x^(n-1))` |

### Tích hợp phép mod:

* Tính `(x^n) % k` mà **không tính toàn bộ x^n**
* Áp dụng phép `% k` sau mỗi bước nhân để tránh số lớn

---

## 🔍 Ví dụ minh họa

**Tính:** `2^10 % 100`

* `2^10 = 1024`
* `1024 % 100 = 24`

---

## 🧑‍💻 Java Code - Power Mod

```java
import java.util.Scanner;

public class PowerMod {
    public static long powerMod(long x, long n, long k) {
        long result = 1;
        x = x % k;  // Rút gọn cơ sở

        while (n > 0) {
            if ((n & 1) == 1) {        // Nếu n lẻ
                result = (result * x) % k;
            }
            x = (x * x) % k;           // Bình phương cơ sở
            n >>= 1;                   // n = n / 2
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long n = sc.nextLong();
        long k = sc.nextLong();

        System.out.println(powerMod(x, n, k));
    }
}
```

---

## 🧠 Giải thích trong code

| Dòng lệnh                   | Ý nghĩa                               |
| --------------------------- | ------------------------------------- |
| `x = x % k`                 | Rút gọn cơ số ban đầu để tránh số lớn |
| `n & 1`                     | Kiểm tra `n` có lẻ không              |
| `result = (result * x) % k` | Nhân vào kết quả nếu mũ là số lẻ      |
| `x = (x * x) % k`           | Bình phương cơ sở tại mỗi bước        |
| `n >>= 1`                   | Chia đôi số mũ (dịch bit sang phải)   |

---

## ✅ Độ phức tạp

* **Thời gian:** O(log n)
* **Bộ nhớ:** O(1)

---

## 📘 Ứng dụng

* Mã hóa RSA
* Thuật toán modular inverse
* Bài toán liên quan đến lũy thừa lớn trong lập trình thi đấu

---

```

---

Nếu bạn muốn mình xuất file `.md`, chỉ cần nói nhé!
```
