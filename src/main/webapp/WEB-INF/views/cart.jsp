<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <title>San pham edit</title>
</head>
<body>
<!--begin::Main-->
<div class="app-main flex-column flex-row-fluid" id="kt_app_main">
    <!--begin::Content wrapper-->
    <div class="d-flex flex-column flex-column-fluid">
        <!--begin::Toolbar-->
        <div id="kt_app_toolbar" class="app-toolbar py-3 py-lg-6">
            <!--begin::Toolbar container-->
            <div id="kt_app_toolbar_container" class="app-container container-xxl d-flex flex-stack">
                <!--begin::Page title-->
                <div class="page-title d-flex flex-column justify-content-center flex-wrap me-3">
                    <!--begin::Title-->
                    <h1 class="page-heading d-flex text-gray-900 fw-bold fs-3 flex-column justify-content-center my-0">
                        Add Order</h1>
                    <!--end::Title-->
                    <!--begin::Breadcrumb-->
                    <ul class="breadcrumb breadcrumb-separatorless fw-semibold fs-7 my-0 pt-1">
                        <!--begin::Item-->
                        <li class="breadcrumb-item text-muted">
                            <a href="/" class="text-muted text-hover-primary">Home</a>
                        </li>
                        <!--end::Item-->
                    </ul>
                    <!--end::Breadcrumb-->
                </div>
                <!--end::Page title-->
                <!--begin::Actions-->
                <div class="d-flex align-items-center gap-2 gap-lg-3">
                    <!--begin::Filter menu-->
                    <div class="m-0">
                        <!--begin::Menu toggle-->
                        <a href="#" class="btn btn-sm btn-flex btn-secondary fw-bold" data-kt-menu-trigger="click"
                           data-kt-menu-placement="bottom-end">
                            <i class="ki-duotone ki-filter fs-6 text-muted me-1">
                                <span class="path1"></span>
                                <span class="path2"></span>
                            </i>Filter</a>
                        <!--end::Menu toggle-->
                        <!--begin::Menu 1-->
                        <div class="menu menu-sub menu-sub-dropdown w-250px w-md-300px" data-kt-menu="true"
                             id="kt_menu_65a121561dc77">
                            <!--begin::Header-->
                            <div class="px-7 py-5">
                                <div class="fs-5 text-gray-900 fw-bold">Filter Options</div>
                            </div>
                            <!--end::Header-->
                            <!--begin::Menu separator-->
                            <div class="separator border-gray-200"></div>
                            <!--end::Menu separator-->
                            <!--begin::Form-->
                            <div class="px-7 py-5">
                                <!--begin::Input group-->
                                <div class="mb-10">
                                    <!--begin::Label-->
                                    <label class="form-label fw-semibold">Status:</label>
                                    <!--end::Label-->
                                    <!--begin::Input-->
                                    <div>
                                        <select class="form-select form-select-solid" multiple="multiple"
                                                data-kt-select2="true" data-close-on-select="false"
                                                data-placeholder="Select option"
                                                data-dropdown-parent="#kt_menu_65a121561dc77" data-allow-clear="true">
                                            <option></option>
                                            <option value="1">Approved</option>
                                            <option value="2">Pending</option>
                                            <option value="2">In Process</option>
                                            <option value="2">Rejected</option>
                                        </select>
                                    </div>
                                    <!--end::Input-->
                                </div>
                                <!--end::Input group-->
                                <!--begin::Input group-->
                                <div class="mb-10">
                                    <!--begin::Label-->
                                    <label class="form-label fw-semibold">Member Type:</label>
                                    <!--end::Label-->
                                    <!--begin::Options-->
                                    <div class="d-flex">
                                        <!--begin::Options-->
                                        <label class="form-check form-check-sm form-check-custom form-check-solid me-5">
                                            <input class="form-check-input" type="checkbox" value="1"/>
                                            <span class="form-check-label">Author</span>
                                        </label>
                                        <!--end::Options-->
                                        <!--begin::Options-->
                                        <label class="form-check form-check-sm form-check-custom form-check-solid">
                                            <input class="form-check-input" type="checkbox" value="2"
                                                   checked="checked"/>
                                            <span class="form-check-label">Customer</span>
                                        </label>
                                        <!--end::Options-->
                                    </div>
                                    <!--end::Options-->
                                </div>
                                <!--end::Input group-->
                                <!--begin::Input group-->
                                <div class="mb-10">
                                    <!--begin::Label-->
                                    <label class="form-label fw-semibold">Notifications:</label>
                                    <!--end::Label-->
                                    <!--begin::Switch-->
                                    <div class="form-check form-switch form-switch-sm form-check-custom form-check-solid">
                                        <input class="form-check-input" type="checkbox" value="" name="notifications"
                                               checked="checked"/>
                                        <label class="form-check-label">Enabled</label>
                                    </div>
                                    <!--end::Switch-->
                                </div>
                                <!--end::Input group-->
                                <!--begin::Actions-->
                                <div class="d-flex justify-content-end">
                                    <button type="reset" class="btn btn-sm btn-light btn-active-light-primary me-2"
                                            data-kt-menu-dismiss="true">Reset
                                    </button>
                                    <button type="submit" class="btn btn-sm btn-primary" data-kt-menu-dismiss="true">
                                        Apply
                                    </button>
                                </div>
                                <!--end::Actions-->
                            </div>
                            <!--end::Form-->
                        </div>
                        <!--end::Menu 1-->
                    </div>
                    <!--end::Filter menu-->
                    <!--begin::Secondary button-->
                    <!--end::Secondary button-->
                    <!--begin::Primary button-->
                    <a href="#" class="btn btn-sm fw-bold btn-primary" data-bs-toggle="modal"
                       data-bs-target="#kt_modal_create_app">Create</a>
                    <!--end::Primary button-->
                </div>
                <!--end::Actions-->
            </div>
            <!--end::Toolbar container-->
        </div>
        <!--end::Toolbar-->
        <!--begin::Content-->
        <div id="kt_app_content" class="app-content flex-column-fluid">
            <!--begin::Content container-->
            <div id="kt_app_content_container" class="app-container container-xxl">
                <!--begin::Form-->
                <form:form action="/orders/create" method="post" modelAttribute="hoaDon" id="kt_ecommerce_edit_order_form" class="form d-flex flex-column flex-lg-row"
                      data-kt-redirect="apps/ecommerce/sales/listing.html">

                    <!--begin::Main column-->
                    <div class="d-flex flex-column flex-lg-row-fluid gap-7 gap-lg-10 mb-7 me-7">
                        <!--begin::Order details-->
                        <div class="card card-flush py-4">
                            <!--begin::Card header-->
                            <div class="card-header">
                                <div class="card-title">
                                    <h2>Select Products</h2>
                                </div>
                            </div>
                            <!--end::Card header-->
                            <!--begin::Card body-->
                            <div class="card-body pt-0">
                                <div class="d-flex flex-column gap-10">
                                    <!--begin::Input group-->
                                    <div>
                                        <!--begin::Label-->
                                        <label class="form-label">Add products to this order</label>
                                        <!--end::Label-->
                                        <!--begin::Selected products-->
                                        <div class="row row-cols-1 row-cols-xl-3 row-cols-md-2 border border-dashed rounded pt-3 pb-1 px-2 mb-5 mh-300px overflow-scroll"
                                             id="kt_ecommerce_edit_order_selected_products">
                                            <!--begin::Empty message-->
                                            <span class="w-100 text-muted">Select one or more products from the list below by ticking the checkbox.</span>
                                            <!--end::Empty message-->
                                        </div>
                                        <!--begin::Selected products-->
                                        <!--begin::Total price-->
                                        <div class="fw-bold fs-4">Total Cost: $
                                            <span id="kt_ecommerce_edit_order_total_price">0.00</span></div>
                                        <!--end::Total price-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Separator-->
                                    <div class="separator"></div>
                                    <!--end::Separator-->
                                    <!--begin::Table-->
                                    <table class="table align-middle table-row-dashed fs-6 gy-5"
                                           id="kt_ecommerce_edit_order_product_table">
                                        <thead>
                                        <tr class="text-start text-gray-500 fw-bold fs-7 text-uppercase gs-0">
                                            <th class="w-25px pe-2"></th>
                                            <th class="min-w-200px">Product</th>
                                            <th class="min-w-100px text-center pe-5">Qty</th>
                                            <th class="min-w-100px text-end pe-5">Total</th>
                                            <th class="w-25px pe-2"></th>
                                        </tr>
                                        </thead>
                                        <tbody class="fw-semibold text-gray-600">
                                        <c:forEach items="${cart}" var="cartItem">
                                            <tr>
                                                <td>
                                                    <div class="form-check form-check-sm form-check-custom form-check-solid">
                                                        <input class="form-check-input" type="checkbox" value="1" checked disabled/>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="d-flex align-items-center"
                                                         data-kt-ecommerce-edit-order-filter="product"
                                                         data-kt-ecommerce-edit-order-id="product_${cartItem.sanPhamChiTiet.id}">
                                                        <!--begin::Thumbnail-->
                                                        <a href="apps/ecommerce/catalog/edit-product.html"
                                                           class="symbol symbol-50px">
                                                            <span class="symbol-label"
                                                                  style="background-image:url(${cartItem.sanPhamChiTiet.hinhAnh});"></span>
                                                        </a>
                                                        <!--end::Thumbnail-->
                                                        <div class="ms-5">
                                                            <!--begin::Title-->
                                                            <a href="apps/ecommerce/catalog/edit-product.html"
                                                               class="text-gray-800 text-hover-primary fs-5 fw-bold">${cartItem.sanPhamChiTiet.sanPham.ten} - ${cartItem.sanPhamChiTiet.ten}</a>
                                                            <!--end::Title-->
                                                            <!--begin::Price-->
                                                            <div class="fw-semibold fs-7">Price: $
                                                                <span data-kt-ecommerce-edit-order-filter="price">${cartItem.sanPhamChiTiet.donGia}</span>
                                                            </div>
                                                            <!--end::Price-->
                                                            <!--begin::SKU-->
                                                            <div class="text-muted fs-7">SKU: 03750002</div>
                                                            <!--end::SKU-->
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-end pe-5" data-order="5">
                                                    <div class="input-group w-50 m-auto">
                                                        <button onclick="location.href='/decrease-quantity-in-cart-item?cid=${cartItem.id}'" class="btn btn-secondary" ${cartItem.quantity <= 1 ? "disabled" : ""}>-</button>
                                                        <input type="text" class="form-control" value="${cartItem.quantity}"/>
                                                        <button onclick="location.href='/increase-quantity-in-cart-item?cid=${cartItem.id}'" class="btn btn-secondary">+</button>
                                                    </div>
                                                </td>
                                                <td class="text-end pe-5" data-order="5">
                                                    <span class="fw-bold text-primary ms-3">${cartItem.quantity * cartItem.sanPhamChiTiet.donGia}</span>
                                                </td>
                                                <td>
                                                    <div class="form-check form-check-sm form-check-custom form-check-solid">
                                                        <div><a href="/delete-item-in-cart?pdid=${cartItem.sanPhamChiTiet.id}"><i class="ki-duotone ki-trash fs-2">
                                                            <span class="path1"></span>
                                                            <span class="path2"></span>
                                                            <span class="path3"></span>
                                                            <span class="path4"></span>
                                                            <span class="path5"></span>
                                                        </i> </a></div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <!--end::Table-->
                                </div>
                            </div>
                            <!--end::Card header-->
                        </div>
                        <!--end::Order details-->

                        <div class="d-flex justify-content-end">
                            <!--begin::Button-->
                            <a href="/" id="kt_ecommerce_edit_order_cancel"
                               class="btn btn-light me-5">Cancel</a>
                            <!--end::Button-->
                            <!--begin::Button-->
                            <button type="submit" id="kt_ecommerce_edit_order_submit" class="btn btn-primary" ${cart.size() == 0 ? "disabled" : ""}>
                                <span class="indicator-label">Go to checkout</span>
                                <span class="indicator-progress">Please wait...
													<span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                            </button>
                            <!--end::Button-->
                        </div>
                    </div>
                    <!--end::Main column-->
                    <!--begin::Aside column-->
                    <div class="w-100 flex-lg-row-auto w-lg-350px me-lg-10">
                        <!--begin::Order details-->
                        <div class="card card-flush py-4">
                            <!--begin::Card header-->
                            <div class="card-header">
                                <div class="card-title">
                                    <h2>Cart Details</h2>
                                </div>
                            </div>
                            <!--end::Card header-->
                            <!--begin::Card body-->
                            <div class="card-body pt-0">
                                <div class="d-flex flex-column gap-10">
                                    <!--begin::Input group-->
                                    <div class="fv-row">
                                        <!--begin::Label-->
                                        <label class="form-label">Order ID</label>
                                        <!--end::Label-->
                                        <!--begin::Auto-generated ID-->
                                        <div class="fw-bold fs-3">#12594</div>
                                        <!--end::Input-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--end::Input group-->
                                    <input type="hidden" name="id" value="${hoaDon.id}"/>
                                    <!--begin::Input group-->
                                    <!--begin::Input group-->
                                    <div class="fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Customer</label>
                                        <!--end::Label-->
                                        <!--begin::Select-->
                                        <form:select path="khachHang.id" class="form-select mb-2">
                                            <option selected disabled hidden>Choose customer</option>
                                            <form:options items="${khachHangList}" itemLabel="ten" itemValue="id"/>
                                        </form:select>
                                        <!--end::Select-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Set the date of the order to process.</div>
                                        <!--end::Description-->
                                        <!--begin::Error-->
                                        <form:errors path="khachHang" class="text-danger fs-7"/>
                                        <!--end::Error-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Order status</label>
                                        <!--end::Label-->
                                        <!--begin::Input-->
                                        <div class="form-check form-check-custom form-check-solid mb-2">
                                            <form:radiobuttons path="trangThai" items="${status}" delimiter=" "
                                                               class="form-check-input"/>
                                        </div>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Set status of the order to process.</div>
                                        <!--end::Description-->
                                        <!--begin::Error-->
                                        <form:errors path="trangThai" class="text-danger fs-7"/>
                                        <!--end::Error-->
                                    </div>
                                    <!--end::Input group-->
                                </div>
                            </div>
                            <!--end::Card header-->
                        </div>
                        <!--end::Order details-->
                    </div>
                    <!--end::Aside column-->
                </form:form>
                <!--end::Form-->
            </div>
            <!--end::Content container-->
        </div>
        <!--end::Content-->
    </div>
    <!--end::Content wrapper-->
    <!--begin::Footer-->
    <div id="kt_app_footer" class="app-footer">
        <!--begin::Footer container-->
        <div class="app-container container-fluid d-flex flex-column flex-md-row flex-center flex-md-stack py-3">
            <!--begin::Copyright-->
            <div class="text-gray-900 order-2 order-md-1">
                <span class="text-muted fw-semibold me-1">2024&copy;</span>
                <a href="https://keenthemes.com" target="_blank" class="text-gray-800 text-hover-primary">Keenthemes</a>
            </div>
            <!--end::Copyright-->
            <!--begin::Menu-->
            <ul class="menu menu-gray-600 menu-hover-primary fw-semibold order-1">
                <li class="menu-item">
                    <a href="https://keenthemes.com" target="_blank" class="menu-link px-2">About</a>
                </li>
                <li class="menu-item">
                    <a href="https://devs.keenthemes.com" target="_blank" class="menu-link px-2">Support</a>
                </li>
                <li class="menu-item">
                    <a href="https://1.envato.market/EA4JP" target="_blank" class="menu-link px-2">Purchase</a>
                </li>
            </ul>
            <!--end::Menu-->
        </div>
        <!--end::Footer container-->
    </div>
    <!--end::Footer-->
</div>
<!--end:::Main-->

</body>
</html>