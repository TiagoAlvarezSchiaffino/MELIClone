import NavbarPayment from "../../components/Payments/NavbarPayment"
import DeliveryOptionPayment from "../../components/Payments/DeliveryOptionPayment"

const DeliveryType = () => {
  return (
    <>
      <section className="bg-[#eeeeee]">
        <NavbarPayment title={"¿Cómo querés recibir o retirar tu compra?"} />

        <div className="flex justify-around gap-7 flex-wrap">
          <DeliveryOptionPayment />

          <div className="bg-[#F5F5F5] font-light text-[#333333] w-full max-w-[400px] divide-y divide-slate-200 flex flex-col items-center mx-24 lg:mr-24 lg:ml-0">
            <div className="flex justify-center items-center flex-col mt-12 w-[330px]">
              <img
                src=""
                alt="Producto"
                className="w-12 h-12 rounded-full"
              />
              <p className="mt-3 mb-1 w-56 leading-5">
              </p>
              <span className="text-sm">Cantidad: 1</span>
            </div>

            <div className="flex justify-between items-center w-[330px] mt-8 gap-48">
              <p className="mt-4">Producto</p>
              <p className="mt-4">$ ******</p>
            </div>

            <div className="flex justify-between items-center w-[330px] mt-4 gap-48 font-normal text-lg">
              <p className="mt-4">Pagás</p>
              <p className="mt-4">$ ******</p>
            </div>
          </div>
        </div>
      </section>
    </>
  )
}

export default DeliveryType
