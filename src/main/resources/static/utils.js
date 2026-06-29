/*document.addEventListener("DOMContentLoaded", () => {
    document.body.insertAdjacentHTML('afterbegin', `
       <head> <link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css">
      </head>
        
<nav class="navbar navbar-expand-lg mb-3">
    <div class="container">

       

        <button class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse"
             id="navbarSupportedContent">

            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link active" href="index.html">
            <i class="fa-solid fa-music"></i>
            MusicBox
        </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link active"
                       href="list.html">
                        <i class="fa-solid fa-table-list"></i>
                        Lista
                    </a>
                </li>
                  <li class="nav-item">
                    <a class="nav-link active"
                       href="album.html">
                        <i class="fa-solid fa-compact-disc"></i>
                        Albumi
                    </a>
                </li>
            </ul>

        </div>
    </div>
</nav>
    `)
})*/

const bootstrapClasses = {
    popup: 'card',
    cancelButton: 'btn btn-danger',
    denyButton: 'btn btn-secondary',
    confirmButton: 'btn btn-primary'
}

function showLoading() {
    Swal.fire({
        title: 'Podaci se učitavaju',
        text: 'Molimo sačekajte dok se učitaju podaci iz MusicBox baze.',
        allowOutsideClick: false,
        customClass: bootstrapClasses,
        didOpen: () => {
            Swal.showLoading();
        }
    });
}

function showConfirm(msg, callback) {
    Swal.fire({
        title: msg,
        showCancelButton: true,
        confirmButtonText: 'Da, želim',
        cancelButtonText: 'Ne, odustani',
        icon: "question",
        customClass: bootstrapClasses
    }).then(result => {
        if (result.isConfirmed) {
            callback()
            Swal.fire({
                title: "Uspešno izvršeno",
                confirmButtonText: 'U redu',
                icon: "success",
                customClass: bootstrapClasses
            })
        }
    })
}

async function retrieveData(url, callback) {
    try {
        const container = document.querySelector('.container')

        if (container) {
            container.hidden = true
        }

        showLoading()

        const rsp = await fetch(url)

        if (rsp.status == 404) {
            Swal.fire({
                icon: 'error',
                title: 'Podatak nije pronađen',
                text: 'Traženi podatak ne postoji.',
                customClass: bootstrapClasses,
            })
            return
        }

        const data = await rsp.json()

        callback(data)

        if (container) {
            container.hidden = false
        }

        Swal.close()

    } catch (e) {
        Swal.fire({
            icon: 'error',
            title: 'Došlo je do greške',
            text: e.message,
            customClass: bootstrapClasses,
        })
    }
}

function formatDate(iso) {
    return new Date(iso).toLocaleString('sr-RS', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    })
}