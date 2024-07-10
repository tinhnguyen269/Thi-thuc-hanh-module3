<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <style>

        .add-phone-btn {
            margin-bottom: 20px;
        }

        table.table-bordered tbody tr td, table.table-bordered thead tr th {
            border: 1px solid #dee2e6;
            text-align: center;
            vertical-align: middle;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <h1>Danh sách sản phẩm</h1>
    <div>
        <p><span>Danh sách top:  <select name="discount" id="discount">

                    <option value="1"> 1 </option>
                    <option value="2"> 2 </option>
                    <option value="3"> 3 </option>
                       </select></span> <span>Sản phẩm được đặt hànd nhiều nhất</span> <button>Xem</button> </p>
    </div>
    <button class="btn btn-primary mt-4 add-phone-btn" onclick="window.location.href='/product?action=create'">Thêm sản phẩm</button>
    <table class="table table-hover table-bordered">
        <thead>
        <tr>
            <th>Số thứ tự</th>
            <th>Tên</th>
            <th>Giá</th>
            <th>Giảm giá</th>
            <th>Số lượng</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${product.name}</td>
                <td>${product.price} VND</td>
                <td>${product.discount} %</td>
                <td>${product.quantity}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
