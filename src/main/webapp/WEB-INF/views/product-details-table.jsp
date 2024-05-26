<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <title>San pham chi tiet edit</title>
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
                        Product details</h1>
                    <!--end::Title-->
                    <!--begin::Breadcrumb-->
                    <ul class="breadcrumb breadcrumb-separatorless fw-semibold fs-7 my-0 pt-1">
                        <!--begin::Item-->
                        <li class="breadcrumb-item text-muted">
                            <a href="index.html" class="text-muted text-hover-primary">Home</a>
                        </li>
                        <!--end::Item-->
                        <!--begin::Item-->
                        <li class="breadcrumb-item">
                            <span class="bullet bg-gray-500 w-5px h-2px"></span>
                        </li>
                        <!--end::Item-->
                        <!--begin::Item-->
                        <li class="breadcrumb-item text-muted">eCommerce</li>
                        <!--end::Item-->
                        <!--begin::Item-->
                        <li class="breadcrumb-item">
                            <span class="bullet bg-gray-500 w-5px h-2px"></span>
                        </li>
                        <!--end::Item-->
                        <!--begin::Item-->
                        <li class="breadcrumb-item text-muted">Catalog</li>
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
                             id="kt_menu_65a1214c6c869">
                            <!--begin::Header-->
                            <div class="px-7 py-5">
                                <div class="fs-5 text-gray-900 fw-bold">Filter Options</div>
                            </div>
                            <!--end::Header-->
                            <!--begin::Menu separator-->
                            <div class="separator border-gray-200"></div>
                            <!--end::Menu separator-->
                            <!--begin::Info-->
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
                                                data-dropdown-parent="#kt_menu_65a1214c6c869" data-allow-clear="true">
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
                <!--begin::Col-->
                <div class="row gy-5 g-xl-10">
                    <!--begin::Col-->
                    <div class="col-xl-4">
                        <!--begin::Info-->
                        <div class="card card-flush py-4">
                            <!--begin::Card header-->
                            <div class="card-header">
                                <div class="card-title">
                                    <h2>Info</h2>
                                </div>
                            </div>
                            <!--end::Card header-->
                            <!--begin::Form-->
                            <form:form id="kt_account_profile_details_form"
                                       class="form fv-plugins-bootstrap5 fv-plugins-framework"
                                       action="/product-details/create" method="post" modelAttribute="sanPhamChiTiet">
                                <!--begin::Card body-->
                                <div class="card-body pt-0">
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Input-->
                                        <div class="image-input image-input-empty image-input-outline image-input-placeholder mb-3"
                                             data-kt-image-input="true">
                                            <!--begin::Preview existing avatar-->
                                            <div class="image-input-wrapper w-150px h-150px"
                                                 style="background-image: url(${sanPham.hinhAnh})"></div>
                                            <!--end::Preview existing avatar-->
                                            <!--begin::Label-->
                                            <label class="btn btn-icon btn-circle btn-active-color-primary w-25px h-25px bg-body shadow"
                                                   data-kt-image-input-action="change" data-bs-toggle="tooltip"
                                                   aria-label="Change avatar" data-bs-original-title="Change avatar"
                                                   data-kt-initialized="1">
                                                <i class="ki-duotone ki-pencil fs-7">
                                                    <span class="path1"></span>
                                                    <span class="path2"></span>
                                                </i>
                                                <!--begin::Inputs-->
                                                <input type="file" name="avatar" accept=".png, .jpg, .jpeg"/>
                                                <input type="hidden" name="avatar_remove">
                                                <!--end::Inputs-->
                                            </label>
                                            <!--end::Label-->
                                            <!--begin::Cancel-->
                                            <span class="btn btn-icon btn-circle btn-active-color-primary w-25px h-25px bg-body shadow"
                                                  data-kt-image-input-action="cancel" data-bs-toggle="tooltip"
                                                  aria-label="Cancel avatar" data-bs-original-title="Cancel avatar"
                                                  data-kt-initialized="1">
															<i class="ki-duotone ki-cross fs-2">
																<span class="path1"></span>
																<span class="path2"></span>
															</i>
														</span>
                                            <!--end::Cancel-->
                                            <!--begin::Remove-->
                                            <span class="btn btn-icon btn-circle btn-active-color-primary w-25px h-25px bg-body shadow"
                                                  data-kt-image-input-action="remove" data-bs-toggle="tooltip"
                                                  aria-label="Remove avatar" data-bs-original-title="Remove avatar"
                                                  data-kt-initialized="1">
															<i class="ki-duotone ki-cross fs-2">
																<span class="path1"></span>
																<span class="path2"></span>
															</i>
														</span>
                                            <!--end::Remove-->
                                        </div>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Set the product thumbnail image. Only *.png, *.jpg
                                            and *.jpeg image files are accepted
                                        </div>
                                        <!--end::Description-->
                                    </div>
                                    <!--end::Input group-->
                                    <input type="hidden" name="id" value="${sanPhamChiTiet.id}"/>
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Product code</label>
                                        <!--end::Label-->
                                        <!--begin::Input-->
                                        <form:input path="maSPCT" class="form-control mb-2"
                                                    placeholder="Product detail code"/>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Enter the product detail code.</div>
                                        <!--end::Description-->
                                        <!--begin::Error-->
                                        <form:errors path="maSPCT" class="text-danger fs-7"/>
                                        <!--end::Error-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Name</label>
                                        <!--end::Label-->
                                        <!--begin::Input-->
                                        <form:input path="ten" class="form-control mb-2"
                                                    placeholder="Name"/>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Enter the product detail's name.</div>
                                        <!--end::Description-->
                                        <!--begin::Error-->
                                        <form:errors path="ten" class="text-danger fs-7"/>
                                        <!--end::Error-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Select group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Product detail's size</label>
                                        <!--end::Label-->
                                        <!--begin::Select-->
                                        <form:select path="kichThuoc.id" class="form-select mb-2">
                                            <option selected disabled hidden>Choose size</option>
                                            <form:options items="${kichThuocList}" itemLabel="ten" itemValue="id"/>
                                        </form:select>
                                        <!--end::Select-->
                                        <!--begin::Error-->
                                        <form:errors path="kichThuoc" class="text-danger fs-7"/>
                                        <!--end::Error-->
                                    </div>
                                    <!--end::Select group-->
                                    <!--begin::Select group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Product detail's color</label>
                                        <!--end::Label-->
                                        <!--begin::Select-->
                                        <form:select path="mauSac.id" class="form-select mb-2">
                                            <option selected disabled hidden>Choose color</option>
                                            <form:options items="${mauSacList}" itemLabel="ten" itemValue="id"/>
                                        </form:select>
                                        <!--end::Select-->
                                        <!--begin::Error-->
                                        <form:errors path="mauSac" class="text-danger fs-7"/>
                                        <!--end::Error-->
                                    </div>
                                    <!--end::Select group-->
                                    <!--begin::Select group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Product detail's product</label>
                                        <!--end::Label-->
                                        <!--begin::Select-->
                                        <form:select path="sanPham.id" class="form-select mb-2">
                                            <option selected disabled hidden>Choose product</option>
                                            <form:options items="${sanPhamList}" itemLabel="ten" itemValue="id"/>
                                        </form:select>
                                        <!--end::Select-->
                                        <!--begin::Error-->
                                        <form:errors path="sanPham" class="text-danger fs-7"/>
                                        <!--end::Error-->
                                    </div>
                                    <!--end::Select group-->
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Product detail quantity</label>
                                        <!--end::Label-->
                                        <!--begin::Input-->
                                        <form:input path="soLuong" type="number" min="1" class="form-control mb-2"
                                                    placeholder="Product detail quantity"/>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Enter the product detail quantity.</div>
                                        <!--end::Description-->
                                        <!--begin::Error-->
                                        <form:errors path="soLuong" class="text-danger fs-7"/>
                                        <!--end::Error-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Product detail price</label>
                                        <!--end::Label-->
                                        <!--begin::Input-->
                                        <form:input path="donGia" type="number" min="50" class="form-control mb-2"
                                                    placeholder="Product detail price"/>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Enter the product detail price.</div>
                                        <!--end::Description-->
                                        <!--begin::Error-->
                                        <form:errors path="donGia" class="text-danger fs-7"/>
                                        <!--end::Error-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="fv-row">
                                        <!--begin::Label-->
                                        <label class="form-label">Status</label>
                                        <!--end::Label-->
                                        <!--begin::Input-->
                                        <div class="form-check form-check-custom form-check-solid mb-2">
                                            <form:radiobuttons path="trangThai" items="${status}" delimiter=" "
                                                               class="form-check-input"/>
                                        </div>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Allow customers to purchase customers that are out
                                            of stock.
                                        </div>
                                        <!--end::Description-->
                                        <!--begin::Error-->
                                        <form:errors path="trangThai" class="text-danger fs-7"/>
                                        <!--end::Error-->
                                        <!--begin::Actions-->
                                        <div class="card-footer d-flex justify-content-end py-6 px-9">
                                            <button type="reset" class="btn btn-light btn-active-light-primary me-2">
                                                Discard
                                            </button>
                                            <button type="submit" class="btn btn-primary"
                                                    id="kt_account_profile_details_submit">Save Changes
                                            </button>
                                        </div>
                                        <!--end::Actions-->
                                    </div>
                                    <!--end::Input group-->
                                </div>
                                <!--end::Card header-->
                            </form:form>
                            <!--end::Form-->
                        </div>
                        <!--end::Info-->
                    </div>
                    <!--end::Col-->
                    <!--begin::Col-->
                    <div class="col-xl-8">
                        <!--begin::Products-->
                        <div class="card card-flush">
                            <!--begin::Card header-->
                            <div class="card-header align-items-center py-5 gap-2 gap-md-5">
                                <!--begin::Form search-->
                                <form action="/product-details/table/search" method="get">
                                    <!--begin::Card title-->
                                    <div class="card-title">
                                        <!--begin::Search-->
                                        <div class="d-flex align-items-center position-relative my-1">
                                            <i class="ki-duotone ki-magnifier fs-3 position-absolute ms-4">
                                                <span class="path1"></span>
                                                <span class="path2"></span>
                                            </i>
                                            <input type="text" name="key" data-kt-ecommerce-product-filter="search"
                                                   class="form-control form-control-solid w-250px ps-12"
                                                   placeholder="Search Product Detail"/>
                                        </div>
                                        <!--end::Search-->
                                    </div>
                                    <!--end::Card title-->
                                </form>
                                <!--end::Form search-->
                                <!--begin::Card toolbar-->
                                <div class="card-toolbar flex-row-fluid justify-content-end gap-5">
                                    <div class="w-100 mw-150px">
                                        <!--begin::Select2-->
                                        <select class="form-select form-select-solid" data-control="select2"
                                                data-hide-search="true" data-placeholder="Status"
                                                data-kt-ecommerce-product-filter="status">
                                            <option></option>
                                            <option value="all">All</option>
                                            <option value="published">Published</option>
                                            <option value="scheduled">Scheduled</option>
                                            <option value="inactive">Inactive</option>
                                        </select>
                                        <!--end::Select2-->
                                    </div>
                                    <!--begin::Add product-->
                                    <a href="" class="btn btn-primary">Add
                                        Product Detail</a>
                                    <!--end::Add product-->
                                </div>
                                <!--end::Card toolbar-->
                            </div>
                            <!--end::Card header-->
                            <!--begin::Card body-->
                            <div class="card-body pt-0">
                                <!--begin::Table-->
                                <table class="table align-middle table-row-dashed fs-6 gy-5"
                                       id="kt_ecommerce_product_table">
                                    <thead>
                                    <tr class="text-start text-gray-500 fw-bold fs-7 text-uppercase gs-0">
                                        <th class="min-w-100px">Product</th>
                                        <th class="text-end min-w-70px">Product detail code</th>
                                        <th class="text-end min-w-70px">Product</th>
                                        <th class="text-end min-w-70px">Size</th>
                                        <th class="text-end min-w-70px">Color</th>
                                        <th class="text-end min-w-70px">Qty</th>
                                        <th class="text-end min-w-70px">Price</th>
                                        <th class="text-end min-w-70px">Status</th>
                                        <th class="text-end min-w-70px">Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody class="fw-semibold text-gray-600">
                                    <c:forEach items="${productDetails}" var="productDetail" varStatus="i">
                                        <tr  ${productDetails.size() == 0 ? "hidden" : ""}>
                                            <td>
                                                <div class="d-flex align-items-center">
                                                    <!--begin::Thumbnail-->
                                                    <a href="apps/ecommerce/catalog/edit-product.html"
                                                       class="symbol symbol-50px">
                                                    <span class="symbol-label"
                                                          style="background-image:url(${productDetail.hinhAnh});"></span>
                                                    </a>
                                                    <!--end::Thumbnail-->
                                                    <div class="ms-5">
                                                        <!--begin::Title-->
                                                        <a href="apps/ecommerce/catalog/edit-product.html"
                                                           class="text-gray-800 text-hover-primary fs-5 fw-bold"
                                                           data-kt-ecommerce-product-filter="product_name">${productDetail.ten}</a>
                                                        <!--end::Title-->
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="text-end pe-0">
                                                <span class="fw-bold">${productDetail.maSPCT}</span>
                                            </td>
                                            <td class="text-end pe-0">
                                                <span class="fw-bold">${productDetail.sanPham.ten}</span>
                                            </td>
                                            <td class="text-end pe-0">
                                                <span class="fw-bold">${productDetail.kichThuoc.ten}</span>
                                            </td>
                                            <td class="text-end pe-0">
                                                <span class="fw-bold">${productDetail.mauSac.ten}</span>
                                            </td>
                                            <td class="text-end pe-0" data-order="6">
                                                <span class="fw-bold ms-3">${productDetail.soLuong}</span>
                                            </td>
                                            <td class="text-end pe-0">${productDetail.donGia}</td>
                                            <td class="text-end pe-0" data-order="Scheduled">
                                                <!--begin::Badges-->
                                                <div class="badge ${productDetail.trangThai ? "badge-light-primary" : "badge-light-danger"}">${productDetail.trangThai ? "Active" : "Locked"}</div>
                                                <!--end::Badges-->
                                            </td>
                                            <td class="text-end">
                                                <a href="#"
                                                   class="btn btn-sm btn-light btn-flex btn-center btn-active-light-primary"
                                                   data-kt-menu-trigger="click" data-kt-menu-placement="bottom-end">Actions
                                                    <i class="ki-duotone ki-down fs-5 ms-1"></i></a>
                                                <!--begin::Menu-->
                                                <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-600 menu-state-bg-light-primary fw-semibold fs-7 w-125px py-4"
                                                     data-kt-menu="true">
                                                    <!--begin::Menu item-->
                                                    <div class="menu-item px-3">
                                                        <a href="/product-details/update?id=${productDetail.id}"
                                                           class="menu-link px-3">Edit</a>
                                                    </div>
                                                    <!--end::Menu item-->
                                                    <!--begin::Menu item-->
                                                    <div class="menu-item px-3">
                                                        <a href="/product-details/delete?id=${productDetail.id}"
                                                           class="menu-link px-3"
                                                           data-kt-ecommerce-product-filter="delete_row">Delete</a>
                                                    </div>
                                                    <!--end::Menu item-->
                                                </div>
                                                <!--end::Menu-->
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <tr ${productDetails.size() > 0 ? "hidden" : ""}>
                                        <td colspan="7" class="text-center">No product detail</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <!--end::Table-->
                                <c:if test="${totalPages > 0}">
                                    <!--begin::Pagination-->
                                    <ul class="pagination">
                                        <li class="page-item previous ${currentPage == 0 ? 'disabled' : ''}">
                                            <a href="/product-details/table?page=${currentPage - 1}&pageSize=${pageSize}"
                                               class="page-link"><i class="previous"></i></a>
                                        </li>
                                        <c:forEach begin="0" end="${totalPages - 1}" var="pageNumber">
                                            <li class="page-item ${currentPage == pageNumber ? 'active' : ''}">
                                                <a href="/product-details/table?page=${pageNumber}&pageSize=${pageSize}"
                                                   class="page-link">${pageNumber + 1}</a>
                                            </li>
                                        </c:forEach>
                                        <li class="page-item next">
                                            <a href="/product-details/table?page=${currentPage + 1}&pageSize=${pageSize}"
                                               class="page-link"><i class="next"></i></a>
                                        </li>
                                    </ul>
                                    <!--end::Pagination-->
                                </c:if>
                            </div>
                            <!--end::Card body-->
                        </div>
                        <!--end::Products-->
                    </div>
                    <!--end::Col-->
                </div>
                <!--end::Col-->
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