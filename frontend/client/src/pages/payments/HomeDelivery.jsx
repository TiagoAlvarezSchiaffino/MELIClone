import NavbarPayment from "../../components/Payments/NavbarPayment";
import ProductDetailPayment from "../../components/Payments/ProductDetailPayment";
import FormNewAddress from "../../components/Payments/FormNewAddress";

const HomeDelivery = () => {
  return (
    <>
      <section className="bg-white sm:bg-[#eeeeee]">
        <NavbarPayment title={"Agregá un domicilio"} />

        <div className="flex justify-around gap-7 2xl:mx-32 flex-wrap">
          <FormNewAddress />
          <ProductDetailPayment />
        </div>
      </section>
    </>
  )
}

export default HomeDelivery