@EjecucionCasos
Feature: Crear Usuario

  Background: 
    Given que accedo al sitio
    And me autentico con las credenciales
      | Usuario       | Clave         |
      ##@externaldata@\src\test\resources\Datadriven\DataDriven.xlsx@Usuario@
   |opensourcecms   |opensourcecms|
    Then valido que el ingreso sea exitoso

  Scenario Outline: Requiero gestionar las operaciones que se pueden realizar con las etiquetas
    Given que me dirijo al menu post y selecciono Tags
    When el sistema muestre el formulario de agregar un nueva etiqueta, completo los campos requeridos
      | NOMBRE   | SLUG    | DESCRIPTION |
      | <NOMBRE> | <SLUG> | <DESCRIPTION>  |
    Then valido que la etiqueta se registre correctamente

    Examples: 
      | NOMBRE         | SLUG  | DESCRIPTION                         |
      ##@externaldata@\src\test\resources\Datadriven\DataDriven.xlsx@NuevaEtiqueta@
   | EtiquetaPrueba    |Input   |Esta es la prueba de automatización|

  Scenario Outline: Requiero gestionar las operaciones que se pueden realizar Usuario
    Given que me dirijo al menu users y selecciono add New
    And el sistema me muestre el formulario de agregar un nuevo usuario ingreso los campos requeridos
      | NOMBREUSUARIO   | EMAIL   | FIRSNAME   | LASTNAME   |
      | <NOMBREUSUARIO> | <EMAIL> | <FIRSNAME> | <LASTNAME> |
    And valido que el usuario se registre correctamente

    Examples: 
      | NOMBREUSUARIO | EMAIL                    | FIRSNAME | LASTNAME | FIRSNAMEUPDATE | LASTNAMEUPDATE |
      ##@externaldata@\src\test\resources\Datadriven\DataDriven.xlsx@NuevoUsuario@
   |Pruebas   |Oscar.rojasroa@gmail.com   |Pruebas   |Pruebas   |Pruebas2   |Pruebas2|
