import { IoSearchOutline } from "react-icons/io5";
import ProductDetailPayment from "../../components/Payments/ProductDetailPayment";
import NavbarPayment from "../../components/Payments/NavbarPayment";
import { MapContainer, TileLayer, Marker, LayersControl, WMSTileLayer, Popup } from "react-leaflet";
import "leaflet/dist/leaflet.css";
import { getLocation } from "../../helpers/getLocation";
import { useEffect, useState } from "react";

// punto de retiro
const DeliveryPoint = () => {
  const [coord, setCoord] = useState(null)

  useEffect(() => {
    getLocation()
      .then(location => {
        const { latitude, longitude } = location
        setCoord([latitude, longitude])
      })
      .catch(error => {
        console.error("Error al obtener la geolocalización:", error)
      })
  }, [])

  return (
    <div>
      <NavbarPayment title={"Elegí un punto de retiro"} />
      <div className=" bg-[#EEEEEE] flex flex-col gap-2 md:items-center xl:flex-row xl:justify-around xl:items-stretch">
        <div className=" w-full lg:w-full xl:w-auto md:px-4 xl:px-0 xl:md:min-h-[calc(100vh-183px)]">
          <h2 className=" hidden sm:block text-[24px] font-[500 pt-5 pb-3">
            Elegí un punto de retiro
          </h2>
          <div className="flex flex-col items-center md:items-start bg-white md:flex-row xl:max-w-[800px] ">
            <div className=" h-full md:w-1/2">
              <div className="bg-[#f4f4f4] pt-3">
                <form className="flex items-center gap-2 border mx-3 h-14 bg-white ">
                  <IoSearchOutline className="text-[25px] text-[#c4c3c3] mx-3" />
                  <input
                    type="text"
                    className="h-full w-full outline-none text-[18px]"
                    placeholder="Buscá una ubicación"
                  />
                </form>
                <div className="flex flex-wrap py-4 gap-2 text-[12px] mx-2 ">
                  <p className="border px-3 rounded-2xl py-1 text-[#929292]">Cierra tarde</p>
                  <p className="border px-3 rounded-2xl py-1 text-[#929292]">
                    Abierto el fin de semana
                  </p>
                  <p className="border px-3 rounded-2xl py-1 text-[#929292]">Punto Pickit</p>
                  <p className=" text-ligthblue">Más filtros</p>
                </div>
              </div>
              <div className="mx-2 py-5 px-3 border-l-4 border-ligthblue">
                <h5 className=" font-[500] text-[18px] mb-1">Punto Pickut - Supermercado</h5>
                <p className="text-[#c4c3c3]">Av. San Martin Sur 2575 | Godoy Cruz - a 1,1 kms.</p>
                <div className="flex justify-between">
                  <p className=" font-[400]">
                    Llega al punto de retiro entre el 16 y 19 de mayo{" "}
                    <span className=" text-green">Gratis</span>
                  </p>
                  <button className=" bg-ligthblue py-1 px-8 text-white rounded-lg">Elegir</button>
                </div>
              </div>
              <div className="mx-2 py-5 px-3 border-l-4 border-white">
                <h5 className=" font-[500] text-[18px] mb-1">
                  Punto Pickut - Herramientas y contrucción
                </h5>
                <p className="text-[#c4c3c3]">Av. San Martin Sur 3878 | Godoy Cruz - a 1,4 kms.</p>
                <div className="flex justify-between">
                  <p className=" font-[400]">
                    Llega al punto de retiro entre el 16 y 19 de mayo{" "}
                    <span className=" text-green">gratis</span>
                  </p>
                  <button className=" bg-ligthblue py-1 px-8 text-white rounded-lg">Elegir</button>
                </div>
              </div>
            </div>
            <div className=" h-[500px] w-[350px] sm:w-[500px] md:w-1/2 xl:w-[450px] xl:h-[573px]">
              {coord ? (
                <MapContainer center={coord} zoom={13} style={{ height: "100%" }}>
                  <TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png" />
                  <Marker position={coord} />
                </MapContainer>
              ) : (
                <p>Obteniendo ubicación...</p>
              )}
            </div>
          </div>
        </div>

        <ProductDetailPayment />
      </div>
    </div>
  )
}

export default DeliveryPoint