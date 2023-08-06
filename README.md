# Aspect Oriented Programming
![Alt text](https://freelancervietnam.vn/wp-content/uploads/2019/11/gioi-thieu-aop.jpg)
## 1. What is AOP
AOP là kiểu lập trình cho phép phân tách chương trình thành các module tách biệt, không phụ thuộc nhau. Chương trình kết hợp các module lại khi hoạt động, nhằm thực hiện các chức năng. Tuy nhiên, chỉ cần chỉnh sửa một module nào đó nếu cần sửa đổi chức năng.
[Example]: Chẳng hạn khi xây dựng hệ thống đăng ký tạo tài khoản cho một trang web. Ngoài việc cho phép người dùng tạo tài khoản (core concern), hệ thống còn phải làm nhiều vấn đề khác (cross – cutting concern). Nào là: kiểm tra ràng buộc, chứng thực người dùng, xử lý ngoại lệ, debug, quản lý transaction, ghi log, đo hiệu suất ứng dụng,… Đồng nghĩa với việc logic của chương trình phải làm ti tỉ việc như: mở/đóng transaction, ghi log, xử lý ngoại lệ… Và khi có nhiều phương thức na ná như vậy trong ứng dụng, code sẽ bị liên kết vào nhau, duplicate code, rồi sẽ phân mảnh nhiều nơi, gây khó khăn đáng kể khi sửa đổi, khi thêm logic mới,…Sử dụng AOP sẽ giúp giải quyết vấn nạn này.
## 2. Một số khái niệm trong lập trình hướng khía cạnh AOP
![Alt text](https://www.collidu.com/media/catalog/product/img/3/c/3ccb92cae2bbd079d90dde608160174a7f4317652fa330a27b4a02173c1fa3b9/aspect-oriented-programming-slide1.png)
- Core concern (primary concern): Chính là requirement, logic xử lý mấu chốt của chương trình
- Cross-cutting concern: là các logic xử lý phụ cần được chương trình thực hiện core concern được xem như logging, security, monitoring, tracing,...
- Joinpoint: là một điểm trong chương trình, là những chỗ chèn được các cross-cutting concern. Joinpoint có thể là ngoại lệ được throw ra, phuongw thức được gọi, hoặc có thể là field được thay đổi. Ví dự, sau khi chạy một method nào đóm chúng ta cần ghi log lại. Joinpoint chính là điểm ngay sau method đó được thực thi.
- Pointcut: có nhiều các nhằm xác định Joinpoint, những các như vậy gọi là Pointcut. Pointcut thưc ra là các biểu thức hoặc có thể là câu lệnh
- Advice: Khi các xử lý phụ được bổ sung vào xử lý chính là Code để thi hành các xử lý đó gọi là Advice. Adice có thể được phân thành các loại sau:
 - Before Advice:  loại này chạy trươc khi được thực hiện các JoinPoint Method
 - After Advice: (Finally Adivce): loại này thực hiện sau JoinPoint. Dù JoinPoint có được thực thi thành công hay không, thầm chí dù có bị exception thì after advice vần thực hiện được
 - After Returning Advice: loại này thực thi sau khi JoinPoint được thực thi thành công, không bị lỗi exception.
 - After Throwing Advice: loại này cung tương tự như After Returning Advice, tuy nhiên dùng cho trường hợp JointPoint thực thi mà throw ra exception
 - Around Advice: Loại này thực hiện xung quanh JoinPoint. Do vậy, người dùng có thể quyết định có thực thi JoinPoint hay không. Ngoài ra, nó cũng cho phép người dùng viết code mà Advice chạy trước hay sau JoinPoint tùy ý. Around Advice dường như có tất cả các chức năng của các loại Advice khác, bởi vậy có thể xem nó là loại quan trọng nhất, mạnh mẽ nhất.
- Aspect: (diện mạo) cũng giống như một Java Class, một Aspect có thể gômf toàn bộ Cross-cutting Concern, các PointCut, các JointPoint, các Advice, Để tạo ra Class Aspect, đơn giản người dùng có thể config trong xml
- Target Object: các đối tượng mà advice được áp dụng gọi là các Target Object
- AOP Proxy:(Uỷ quyền) sử dụng để cài đặt các Aspect
- Weaving: (Dệt) qúa trinhg kết nối các thành phần Aspect và Non-aspect(chăng hạn như Object, Types) của một chương trình để tạo nên Advised Object gọi là Weaving
