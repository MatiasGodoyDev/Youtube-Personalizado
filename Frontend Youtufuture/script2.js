document.addEventListener('DOMContentLoaded', () => {
    setupCarousel();
    // Elementos de los modales
    const modals = {
        loginModal: document.getElementById('loginModal'),
        registerModal: document.getElementById('registerModal'),
        crearCanalModal: document.getElementById('CrearCanal'),
        recoverAccountModal: document.getElementById('Recovery')
    };

    // Botones para abrir modales
    const openModalButtons = {
        openLoginBtn: document.getElementById('openModal'),
        openRegisterBtn: document.querySelector('.register-btn'),
        openCrearCanalBtn: document.querySelector('.cannal-btn'),
        openRecoverAccountBtn: document.querySelector('.recover-account-btn')
    };

    // Botones para cerrar modales
    const closeModalButtons = {
        closeLoginBtn: document.getElementById('closeModal'),
        closeRegisterBtn: document.getElementById('closeRegisterModal'),
        closeCrearCanalBtn: document.getElementById('closeCrearCanalModal'),
        closeRecoverAccountBtn: document.getElementById('closeRecoveryModal')
    };

    // Funciones para abrir y cerrar modales
    function openModal(modal) {
        if (modal) modal.style.display = 'flex';
    }

    function closeModal(modal) {
        if (modal) modal.style.display = 'none';
    }

    // Función para manejar el botón "back-btn" en los modales
    function setBackBtn(modal, backBtn, previousModal) {
        if (backBtn) {
            backBtn.addEventListener('click', () => {
                closeModal(modal);
                openModal(previousModal);
            });
        }
    }

    // Obtener los botones de retroceso para cada modal
    const backBtns = {
        recoveryBackBtn: document.querySelector('#Recovery .back-btn'),
        registerBackBtn: document.querySelector('#registerModal .back-btn'),
        crearCanalBackBtn: document.querySelector('#CrearCanal .back-btn')
    };

    // Establecer los back-buttons para cada modal
    setBackBtn(modals.recoverAccountModal, backBtns.recoveryBackBtn, modals.loginModal);
    setBackBtn(modals.registerModal, backBtns.registerBackBtn, modals.loginModal);
    setBackBtn(modals.crearCanalModal, backBtns.crearCanalBackBtn, modals.registerModal);

    // Eventos para los botones de cierre de modales
    closeModalButtons.closeLoginBtn?.addEventListener('click', () => closeModal(modals.loginModal));
    closeModalButtons.closeRegisterBtn?.addEventListener('click', () => closeModal(modals.registerModal));
    closeModalButtons.closeCrearCanalBtn?.addEventListener('click', () => closeModal(modals.crearCanalModal));
    closeModalButtons.closeRecoverAccountBtn?.addEventListener('click', () => closeModal(modals.recoverAccountModal));

    // Lógica para abrir modales
    openModalButtons.openLoginBtn?.addEventListener('click', () => openModal(modals.loginModal));
    openModalButtons.openRegisterBtn?.addEventListener('click', () => {
        closeModal(modals.loginModal);
        openModal(modals.registerModal);
    });
    openModalButtons.openRecoverAccountBtn?.addEventListener('click', () => {
        closeModal(modals.loginModal);
        openModal(modals.recoverAccountModal);
    });
    openModalButtons.openCrearCanalBtn?.addEventListener('click', () => {
        closeModal(modals.registerModal);
        openModal(modals.crearCanalModal);
    });

    // Cerrar modales al hacer clic fuera del contenido
    window.addEventListener('click', (event) => {
        Object.values(modals).forEach(modal => {
            if (event.target === modal) closeModal(modal);
        });
    });

    // Inicializar los modales que no están visibles al principio
    modals.loginModal.style.display = 'none';
    modals.registerModal.style.display = 'none';
    modals.recoverAccountModal.style.display = 'none';
    modals.crearCanalModal.style.display = 'none';

    // Lógica para las secciones
    const secciones = {
        inicioLink: document.getElementById('inicioLink'),
        reelsLink: document.getElementById('reelsLink'),
        tendenciasLink: document.getElementById('tendenciasLink'),
        futbolLink: document.getElementById('futbolLink'),
        suscriptoresLink: document.getElementById('suscriptoresLink')
    };

    const sections = {
        inicioSection: document.getElementById('inicio'),
        reelsSection: document.getElementById('reels'),
        tendenciasSection: document.getElementById('tendencias'),
        futbolSection: document.getElementById('futbolSection'),
        suscriptoresSection: document.getElementById('suscriptoresSection')
    };

    // Función para ocultar todas las secciones
    function hideSections() {
        Object.values(sections).forEach(section => section.style.display = 'none');
    }

    // Funciones para mostrar las secciones
    secciones.inicioLink.addEventListener('click', (e) => {
        e.preventDefault();
        hideSections();
        sections.inicioSection.style.display = 'block';
    });

    secciones.reelsLink.addEventListener('click', (e) => {
        e.preventDefault();
        hideSections();
        sections.reelsSection.style.display = 'block';
    });

    secciones.tendenciasLink.addEventListener('click', (e) => {
        e.preventDefault();
        hideSections();
        sections.tendenciasSection.style.display = 'block';
    });

    secciones.futbolLink.addEventListener('click', (e) => {
        e.preventDefault();
        hideSections();
        sections.futbolSection.style.display = 'block';
        generarTablaFutbol(); // Generar la tabla de fútbol
    });

    secciones.suscriptoresLink.addEventListener('click', (e) => {
        e.preventDefault();
        hideSections();
        sections.suscriptoresSection.style.display = 'block';
    });

    // Función para generar la tabla de fútbol
    function generarTablaFutbol() {
        const equipos = [
            { nombre: "Real Madrid", PJ: 10, victorias: 8, empates: 1, derrotas: 1, goles: 24, puntos: 25 },
            { nombre: "FC Barcelona", PJ: 10, victorias: 7, empates: 2, derrotas: 1, goles: 21, puntos: 23 },
            { nombre: "Atlético de Madrid", PJ: 10, victorias: 6, empates: 3, derrotas: 1, goles: 19, puntos: 21 },
            { nombre: "Sevilla FC", PJ: 10, victorias: 5, empates: 4, derrotas: 1, goles: 17, puntos: 19 },
            { nombre: "Real Betis", PJ: 10, victorias: 5, empates: 3, derrotas: 2, goles: 15, puntos: 18 },
            { nombre: "Villarreal CF", PJ: 10, victorias: 4, empates: 2, derrotas: 4, goles: 13, puntos: 14 },
            { nombre: "Cádiz CF", PJ: 10, victorias: 2, empates: 2, derrotas: 6, goles: 7, puntos: 8 },
            { nombre: "Granada CF", PJ: 10, victorias: 1, empates: 3, derrotas: 6, goles: 6, puntos: 6 },
            { nombre: "Real Valladolid", PJ: 10, victorias: 1, empates: 3, derrotas: 6, goles: 5, puntos: 6 },
            { nombre: "Almería", PJ: 10, victorias: 0, empates: 4, derrotas: 6, goles: 4, puntos: 4 }
        ];

        // Ordenar los equipos por puntos en orden descendente
        equipos.sort((a, b) => b.puntos - a.puntos);

        const tablaCuerpo = document.getElementById('tablaCuerpo');
        tablaCuerpo.innerHTML = ''; // Limpiar el contenido de la tabla antes de agregar nuevas filas

        // Crear las filas de la tabla
        equipos.forEach((equipo, index) => {
            const fila = document.createElement('tr');

            // Añadir clases para resaltar las posiciones
            if (index === 0) {
                fila.classList.add('primer-lugar'); // Primer lugar
            } else if (index === 1) {
                fila.classList.add('segundo-lugar'); // Segundo lugar
            } else if (index === 2) {
                fila.classList.add('tercer-lugar'); // Tercer lugar
            }

            // Crear las celdas
            const posicion = document.createElement('td');
            posicion.textContent = index + 1;
            const nombre = document.createElement('td');
            nombre.textContent = equipo.nombre;
            const PJ = document.createElement('td');
            PJ.textContent = equipo.PJ;
            const victorias = document.createElement('td');
            victorias.textContent = equipo.victorias;
            const empates = document.createElement('td');
            empates.textContent = equipo.empates;
            const derrotas = document.createElement('td');
            derrotas.textContent = equipo.derrotas;
            const goles = document.createElement('td');
            goles.textContent = equipo.goles;
            const puntos = document.createElement('td');
            puntos.textContent = equipo.puntos;

            // Añadir las celdas a la fila
            fila.appendChild(posicion);
            fila.appendChild(nombre);
            fila.appendChild(PJ);
            fila.appendChild(victorias);
            fila.appendChild(empates);
            fila.appendChild(derrotas);
            fila.appendChild(goles);
            fila.appendChild(puntos);

            // Añadir la fila al cuerpo de la tabla
            tablaCuerpo.appendChild(fila);
        });
    }

    // Inicializar la visualización de la sección de inicio por defecto
    sections.inicioSection.style.display = 'block';

    // ** Funcionalidad de búsqueda y filtrado de videos **

// Selección de elementos
// Selección de elementos
const searchButton = document.getElementById('searchIcon');
const searchBar = document.getElementById('searchBar');
const searchInput = document.getElementById('searchInput');

// Alternar visibilidad al hacer clic en el botón
searchButton.addEventListener('click', (e) => {
    e.preventDefault(); // Prevenir comportamiento por defecto del enlace
    searchBar.classList.toggle('active');
    if (searchBar.classList.contains('active')) {
        searchInput.focus(); // Enfocar el input
    }
});

// Cerrar la barra al hacer clic fuera de ella
document.addEventListener('click', (event) => {
    if (!searchBar.contains(event.target) && !searchButton.contains(event.target)) {
        searchBar.classList.remove('active');
    }
});

// Cerrar la barra con la tecla "Escape"
document.addEventListener('keydown', (event) => {
    if (event.key === 'Escape') {
        searchBar.classList.remove('active');
    }
});


// Mostrar resultados filtrados
function showVideos(videosToShow) {
    searchSection.innerHTML = ''; // Limpiar los videos previos
    videosToShow.forEach(video => {
        const videoElement = document.createElement('div');
        videoElement.classList.add('video-item');
        videoElement.textContent = video.title;
        searchSection.appendChild(videoElement);
    });
}

// Filtrar videos según lo que se escribe
searchInput.addEventListener('input', () => {
    const query = searchInput.value.toLowerCase();
    if (query === "") {
        showVideos([]); // Si no hay texto, no mostrar nada
    } else {
        const filteredVideos = videos.filter(video =>
            video.title.toLowerCase().includes(query)
        );
        showVideos(filteredVideos);
    }
});



    const apiKey = 'e7373904f882f0afdd9e67c0df6d30a7';

    function getWeather() {
        const city = "Buenos Aires"; // Ciudad fija (Buenos Aires)
        fetch(`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric&lang=es`)
            .then(response => response.json())
            .then(data => {
                if (data.cod === 200) {
                    const temp = data.main.temp;
                    const weatherIcon = `https://openweathermap.org/img/wn/${data.weather[0].icon}@2x.png`; // Obtiene el ícono del clima

                    document.getElementById('weatherInfo').innerHTML = `
                            <img src="${weatherIcon}" alt="Icono de clima" class="weather-icon" />
                            Buenos Aires: <strong>${temp}°C</strong>
                        `;
                } else {
                    document.getElementById('weatherInfo').innerHTML = `<p>No se encontró información para ${city}</p>`;
                }
            })
            .catch(error => {
                document.getElementById('weatherInfo').innerHTML = `<p>Error al obtener los datos</p>`;
            });
    }

    // Llamada inmediata para cargar el clima al cargar la página
    window.onload = getWeather;

    function setupCarousel() {
        // Función para configurar el carrusel
        function initializeCarousel(trackSelector, leftButtonSelector, rightButtonSelector) {
            const track = document.querySelector(trackSelector);
            const videos = document.querySelectorAll(`${trackSelector} .video-card`);
            const leftButton = document.querySelector(leftButtonSelector);
            const rightButton = document.querySelector(rightButtonSelector);
            const videoWidth = videos[0].offsetWidth + 10; // Ancho del video + márgenes
            let currentIndex = 0;
    
            // Clonamos todos los videos y los agregamos al final para el loop infinito
            videos.forEach(video => {
                const videoClone = video.cloneNode(true);
                track.appendChild(videoClone);
            });
    
            // Ajustamos el ancho del track después de la clonación
            track.style.width = `${videoWidth * (videos.length * 2)}px`; // Doble el número de videos
    
            // Función para actualizar el desplazamiento del carrusel
            function updateCarousel() {
                const offset = -currentIndex * videoWidth;
                track.style.transition = "transform 0.3s ease"; // Transición suave
                track.style.transform = `translateX(${offset}px)`;
            }
    
            // Mover hacia la derecha (con salto al principio al llegar al final)
            rightButton.addEventListener('click', function () {
                currentIndex++;
    
                // Si hemos llegado al final (más allá del último video original), reiniciamos al primer video
                if (currentIndex >= videos.length) {
                    // Desactivar la transición para evitar un deslizamiento indeseado
                    track.style.transition = "none";
    
                    // Salto inmediato al primer video
                    currentIndex = 0;
                    track.style.transform = `translateX(0)`; // Salto inmediato al primer video
    
                    // Restaura la transición para las siguientes interacciones
                    setTimeout(() => {
                        track.style.transition = "transform 0.3s ease";
                        updateCarousel();
                    }, 20);
                } else {
                    updateCarousel();
                }
            });
    
            // Mover hacia la izquierda (con salto al último al llegar al primero)
            leftButton.addEventListener('click', function () {
                currentIndex--;
    
                if (currentIndex < 0) {
                    // Cuando llegamos al primer video, movemos al final
                    track.style.transition = "none"; // Desactivar transición temporalmente
                    currentIndex = videos.length - 1; // Salta al último video
                    track.style.transform = `translateX(${-currentIndex * videoWidth}px)`; // Reajustamos sin transición
                    // Restaura la transición para las siguientes interacciones
                    setTimeout(() => {
                        track.style.transition = "transform 0.3s ease";
                        updateCarousel();
                    }, 20);
                } else {
                    updateCarousel();
                }
            });
    
            // Inicializar el carrusel
            updateCarousel();
        }
    
        // Llamamos a la función para el primer carrusel
        initializeCarousel('.carousel-track', '.carousel-control.left', '.carousel-control.right');
    
        // Llamamos a la función para el segundo carrusel
        initializeCarousel('.carousel-wrapper .carousel-tracks', '.carousel-wrapper .boton-izquierda', '.carousel-wrapper .boton-derecha');
    }
    
    // Llamamos a la función de configuración al cargar la página
    document.addEventListener('DOMContentLoaded', setupCarousel);
    

    function setupVerticalCarousel() {
        const verticalCarousel = document.getElementById('reels');
        const verticalCarouselItems = verticalCarousel.querySelectorAll('.video-reel');  // Seleccionamos todos los videos
        const reelContainer = verticalCarousel.querySelector('.reels-container');
        let currentIndex = 0;  // Índice para controlar el video visible
    
        // Función para actualizar la posición del carrusel
        function updateCarouselPosition() {
            const offset = -currentIndex * verticalCarouselItems[0].offsetHeight;  // Desplazamiento basado en la altura del primer video
            reelContainer.style.transform = `translateY(${offset}px)`;  // Movemos el carrusel verticalmente
        }
    
        // Función para mostrar el siguiente reel (bajar)
        function showNext() {
            if (currentIndex < verticalCarouselItems.length - 1) {
                currentIndex++;  // Mueve al siguiente video
            } else {
                currentIndex = 0;  // Si llegamos al final, volvemos al principio
            }
            updateCarouselPosition();
        }
    
        // Función para mostrar el reel anterior (subir)
        function showPrev() {
            if (currentIndex > 0) {
                currentIndex--;  // Mueve al video anterior
            } else {
                currentIndex = verticalCarouselItems.length - 1;  // Si estamos al principio, vamos al final
            }
            updateCarouselPosition();
        }
    
        // Asegurarnos de que los botones están correctamente definidos
        const nextBtn = verticalCarousel.querySelector('.carousel-arrow.down');  // Usamos el selector correcto para el botón de "abajo"
        const prevBtn = verticalCarousel.querySelector('.carousel-arrow.up');  // Usamos el selector correcto para el botón de "arriba"
    
        // Verificar si los botones existen en el DOM
        if (prevBtn && nextBtn) {
            console.log('Botones encontrados: ', prevBtn, nextBtn);  // Depuración
    
            // Agregar los eventos de clic correctamente
            prevBtn.addEventListener('click', function() {
                console.log('Botón arriba clickeado');  // Verificar si el clic es detectado
                showPrev();
            });
    
            nextBtn.addEventListener('click', function() {
                console.log('Botón abajo clickeado');  // Verificar si el clic es detectado
                showNext();
            });
        } else {
            console.error('No se encontraron los botones de navegación.');
        }
    
        // Iniciar mostrando el primer reel
        updateCarouselPosition();
    }
    
    // Iniciar el carrusel al cargar la página
    window.addEventListener('DOMContentLoaded', setupVerticalCarousel);
    



    function tendenciaCarousel(){
        const track = document.querySelector('.trend-track');
        const videos = document.querySelectorAll('.trend-card');
        const leftButton = document.querySelector('.trend-control.prev');
        const rightButton = document.querySelector('.trend-control.next');
        const videoWidth = videos[0].offsetWidth + 250;
        let currentIndex = 0;
    
        // Clonar los videos para crear un carrusel infinito
        videos.forEach(video => {
            const videoClone = video.cloneNode(true);
            track.appendChild(videoClone);
        });
    
        // Ajustar el ancho del track (contenedor)
        track.style.width = `${videoWidth * (videos.length * 2)}px`;
    
        // Función para actualizar la posición del carrusel
        function updateTendencia(){
            const offset = -currentIndex * videoWidth;
            track.style.transition = "transform 0.3s ease";
            track.style.transform = `translateX(${offset}px)`;
        }
    
        // Evento para el botón derecho
        rightButton.addEventListener('click', function(){
            currentIndex++;
    
            if(currentIndex >= videos.length){
                track.style.transition = "none";
                currentIndex = 0;
                track.style.transform = `translateX(0)`; 
    
                setTimeout(() => {
                    track.style.transition = "transform 0.3s ease";
                    updateTendencia();
                }, 150);
            } else {
                updateTendencia();
            }
        });
    
        // Evento para el botón izquierdo
        leftButton.addEventListener('click', function(){
            currentIndex--;
    
            if(currentIndex < 0){
                track.style.transition = "none";
                currentIndex = videos.length - 1; // Corregir el índice
                track.style.transform = `translateX(${-currentIndex * videoWidth}px)`;
    
                setTimeout(() => {
                    track.style.transition = "transform 0.3s ease";
                    updateTendencia();
                }, 150);
            } else {
                updateTendencia();
            }
        });
    
        // Llamar a la función para mover el carrusel
        updateTendencia();
    }
    window.addEventListener('DOMContentLoaded', tendenciaCarousel);
      
});
