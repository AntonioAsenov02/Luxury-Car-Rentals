document.addEventListener('DOMContentLoaded', function() {
    fetch(`http://localhost:8080/cars/details/api/pricing`)
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector('.table tbody');

            data.forEach(carDetails => {
                const newRow = document.createElement('tr');
                newRow.innerHTML = `
                    <td class="car-image"><div class="img" style="background-image:url('${carDetails.imageUrl}');"></div></td>
                    <td class="product-name">
                        <h3>${carDetails.brand} ${carDetails.model}</h3>
                        <!-- Display rating stars -->
                        <p class="mb-0 rated text-warning">
                            ${generateStars(carDetails.rating)}
                        </p>
                    </td>
                    <!-- Add other columns for per hour rate, per day rate, per month rate, etc. -->
                    <td class="price">
                        <p class="btn-custom"><a href="#">Rent a car</a></p>
                        <div class="price-rate">
                            <h3>
                                <span class="num"><small class="currency">$</small>${carDetails.pricePerHour}</span>
                                <span class="per">/per hour</span>
                            </h3>
                        </div>
                    </td>
                    
                    <td class="price">
                        <p class="btn-custom"><a href="#">Rent a car</a></p>
                        <div class="price-rate">
                            <h3>
                                <span class="num"><small class="currency">$</small>${carDetails.pricePerDay}</span>
                                <span class="per">/per day</span>
                            </h3>
                        </div>
                    </td>
                    
                    <td class="price">
                        <p class="btn-custom"><a href="#">Rent a car</a></p>
                        <div class="price-rate">
                            <h3>
                                <span class="num"><small class="currency">$</small>${carDetails.pricePerMonth}</span>
                                <span class="per">/per month</span>
                            </h3>
                        </div>
                    </td>
                `;
                tableBody.appendChild(newRow);
            });
        })
        .catch(error => console.error('Error fetching data:', error));

    function generateStars(rating) {
        let stars = '';
        for (let i = 0; i < rating; i++) {
            stars += '<i class="fa-solid fa-star"></i>';
        }
        return stars;
    }
});