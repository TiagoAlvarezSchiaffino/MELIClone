import { AiOutlineCheck } from "react-icons/ai"

const Warranty = () => {
  return (
    <div className="text-[#504A4A] px-3 bg-grey flex flex-col gap-1 min-h-screen">
      <h2 className=" text-[18px] font-[500] text-[#504A4A] text-center my-5">
        Añadir una protección
      </h2>
      <div className="flex flex-col gap-2 md:gap-4 items-center lg:flex-row lg:justify-center lg:items-center lg:h-[600px]">
        <article className=" border border-ligthblue flex flex-col text-[#504A4A] max-w-[360px]  bg-white rounded-lg md:w-[460px] lg:h-[300px]">
          <div className=" flex justify-end">
            <h4 className=" bg-ligthblue text-white w-fit px-5 rounded-bl-lg rounded-tr-lg">
              Mejor costo y beneficio
            </h4>
          </div>
          <div className="p-4">
            <h3 className=" text-[16px] font-[500] ">Seguro contra robo y daños</h3>
            <p className=" text-[12px] mb-2">
              Autorizado por la{" "}
              <span className=" text-ligthblue">Superintendencia de Seguros de la Noción</span>{" "}
            </p>
            <hr className="mb-2" />
            <h4 className=" text-[12px] font-[500] mb-2">
              Durante 1 año protegés tu producto y contas con:
            </h4>
            <ul className="flex flex-col gap-2 mb-3">
              <li className="flex items-center gap-2 text-[10px]">
                <AiOutlineCheck className=" text-ligthblue" />
                Reparaciones por daños accidentales y rotura de pantalla.
              </li>
              <li className="flex items-center gap-2 text-[10px]">
                <AiOutlineCheck className=" text-ligthblue" />
                Indemnización por robo, hurto o si no se puede reparar.
              </li>
            </ul>
            <p className=" text-[12px] font-[500] text-ligthblue mb-3">conoce como funciona</p>
            <div className="flex gap-3">
              <div>
                <p className=" text-[18px] font-[500]">6x $ ******</p>{" "}
                <p className="text-[10px]">$ ******</p>
              </div>
              <div className="flex pt-2">
                <p className=" text-green font-[500] text-[10px]">Sin interés</p>
              </div>
            </div>
          </div>
        </article>

        <article className=" border flex flex-col text-[#504A4A] max-w-[360px]  bg-white rounded-lg md:w-[460px] lg:h-[300px]">
          <div className="p-4">
            <h3 className=" text-[16px] font-[500] mb-3">Garantia extendida</h3>

            <hr className="mb-2" />
            <h4 className=" text-[12px] font-[500] mb-2">
              Cuidá tu producto por 1 año más, luego de que finalice la garantía de fabrica.
            </h4>
            <ul className="flex flex-col gap-2 mb-3">
              <li className="flex items-center gap-2 text-[10px]">
                <AiOutlineCheck className=" text-ligthblue" />
                Cubre todo tipo de fallas que no sean por mal uso o accidentes.
              </li>
              <li className="flex items-center gap-2 text-[10px]">
                <AiOutlineCheck className=" text-ligthblue" />
                ¡Sin limite de reparaciones! con repuestos originales y servicio técnico oficial.
              </li>
              <li className="flex items-center gap-2 text-[10px]">
                <AiOutlineCheck className=" text-ligthblue" />
                Devolución de 100% del valor actualizado, si no se puede reparar.
              </li>
            </ul>
            <p className=" text-[12px] font-[500] text-ligthblue mb-3">conoce como funciona</p>
            <div className="flex gap-2">
              <p className=" font-[500] text-[10px] text-[#999999] line-through"> $ ******</p>{" "}
              <p className=" text-green font-[500] text-[10px]">5% OFF</p>
            </div>
            <div className="flex gap-3">
              <div>
                <p className=" text-[18px] font-[500]">6x $ ******</p>{" "}
                <p className="text-[10px]">$ ******</p>
              </div>
              <div className="flex pt-2">
                <p className=" text-green font-[500] text-[10px]">Sin interés</p>
              </div>
            </div>
          </div>
        </article>
      </div>
    </div>
  )
}

export default Warranty
