<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <title>San pham ${pid}</title>
</head>
<body>
<!--begin::Main-->
<div class="app-main flex-column flex-row-fluid" id="kt_app_main">
    <!--begin::Content wrapper-->
    <div class="d-flex flex-column flex-column-fluid">
        <!--begin::Toolbar-->
        <div id="kt_app_toolbar" class="app-toolbar py-3 py-lg-6">
            <!--begin::Toolbar container-->
            <div id="kt_app_toolbar_container" class="app-container container-fluid d-flex flex-stack">
                <!--begin::Page title-->
                <div class="page-title d-flex flex-column justify-content-center flex-wrap me-3">
                    <!--begin::Title-->
                    <h1 class="page-heading d-flex text-gray-900 fw-bold fs-3 flex-column justify-content-center my-0">
                        Multipurpose</h1>
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
            </div>
            <!--end::Toolbar container-->
        </div>
        <!--end::Toolbar-->
        <!--begin::Content-->
        <div id="kt_app_content" class="app-content flex-column-fluid">
            <!--begin::Content container-->
            <div id="kt_app_content_container" class="app-container container-fluid">
                <!--begin::Row-->
                <div class="row g-5 gx-xl-10 mb-5 mb-xl-10">
                    <!--begin::Col-->
                    <div class="col-md-6 col-lg-6 col-xl-6 col-xxl-12 mb-md-5 mb-xl-10">
                        <!--begin::Row-->
                        <div class="row g-5 gx-xl-10 mb-5 mb-xl-10">
                            <c:forEach items="${productDetails}" var="pd">
                                <!--begin::Col-->
                                <div ${productDetails.size() == 0 ? "hidden" : ""}
                                        class="col-md-6 col-lg-6 col-xl-6 col-xxl-3 mb-md-5 mb-xl-10">
                                    <!--begin::Product card-->
                                    <div class="card-xl-stretch me-md-6">
                                        <!--begin::Overlay-->
                                        <span class="d-block overlay mb-4"
                                              data-fslightbox="lightbox-hot-sales">
                                            <!--begin::Image-->
                                            <div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded min-h-175px"
                                                 style="background-image:url('${pd.hinhAnh}')"></div>
                                            <!--end::Image-->
                                            <!--begin::Action-->
                                            <div class="overlay-layer bg-dark card-rounded bg-opacity-25">
                                                <i class="ki-duotone ki-eye fs-2x text-white"></i>
                                            </div>
                                            <!--end::Action-->
                                        </span>
                                        <!--end::Overlay-->
                                        <!--begin::Body-->
                                        <div class="m-0">
                                            <!--begin::Bestseller-->
                                            <span class="badge badge-success">Bestseller</span>
                                            <!--end::Bestseller-->
                                            <!--begin::Title-->
                                            <span
                                                    class="fs-4 text-gray-900 fw-bold text-hover-primary text-gray-900 lh-base">${pd.sanPham.ten} - ${pd.ten}</span>
                                            <!--end::Title-->
                                            <!--begin::Author-->
                                            <div class="base text-gray-600 mt-2 mb-2">
                                                Luu Yen
                                            </div>
                                            <!--end::Author-->
                                            <!--begin::Rating-->
                                            <div class="d-flex gap-2 mt-2 mb-2">
                                                <!--begin::Average-->
                                                <div class="fw-bold base text-gray-900">
                                                    5.0
                                                </div>
                                                <!--end::Average-->
                                                <!--begin::Star-->
                                                <div class="rating">
                                                    <div class="rating-label checked">
                                                        <i class="ki-duotone ki-star base"></i>
                                                    </div>
                                                    <div class="rating-label checked">
                                                        <i class="ki-duotone ki-star base"></i>
                                                    </div>
                                                    <div class="rating-label checked">
                                                        <i class="ki-duotone ki-star base"></i>
                                                    </div>
                                                    <div class="rating-label checked">
                                                        <i class="ki-duotone ki-star base"></i>
                                                    </div>
                                                    <div class="rating-label checked">
                                                        <i class="ki-duotone ki-star base"></i>
                                                    </div>
                                                </div>
                                                <!--end::Star-->
                                                <!--begin::Count-->
                                                <div class="base text-gray-600">
                                                    (998)
                                                </div>
                                                <!--end::Count-->
                                            </div>
                                            <!--end::Rating-->
                                            <!--begin::Price-->
                                            <div class="fw-bold fs-4 text-gray-900 mt-2 mb-2">
                                                ₫${pd.donGia}
                                            </div>
                                            <!--end::Price-->
                                            <!--begin::Btn add to cart-->
                                            <a href="/add-to-cart?pid=${pid}&pdid=${pd.id}"
                                               class="btn btn-primary w-100">Thêm vào giỏ hàng</a>
                                            <!--end::Btn add to cart-->
                                        </div>
                                        <!--end::Body-->
                                    </div>
                                    <!--end::Product card-->
                                </div>
                                <!--end::Col-->
                            </c:forEach>
                            <div ${productDetails.size() > 0 ? "hidden" : ""}>No product detail</div>
                        </div>
                        <!--end::Row-->
                        <c:if test="${totalPages > 0}">
                            <!--begin::Pagination-->
                            <ul class="pagination">
                                <li class="page-item previous ${currentPage == 0 ? 'disabled' : ''}">
                                    <a href="/product-${pid}/details?page=${currentPage - 1}&pageSize=${pageSize}"
                                       class="page-link"><i class="previous"></i></a>
                                </li>
                                <c:forEach begin="0" end="${totalPages - 1}" var="pageNumber">
                                    <li class="page-item ${currentPage == pageNumber ? 'active' : ''}">
                                        <a href="/product-${pid}/details?page=${pageNumber}&pageSize=${pageSize}"
                                           class="page-link">${pageNumber + 1}</a>
                                    </li>
                                </c:forEach>
                                <li class="page-item next">
                                    <a href="/product-${pid}/details?page=${currentPage + 1}&pageSize=${pageSize}"
                                       class="page-link"><i class="next"></i></a>
                                </li>
                            </ul>
                            <!--end::Pagination-->
                        </c:if>
                    </div>
                    <!--end::Col-->
                </div>
                <!--end::Row-->

            </div>
            <!--end::Content container-->
        </div>
        <!--end::Content-->
    </div>
    <!--end::Content wrapper-->
</div>
<!--end::Main-->

</body>
</html>