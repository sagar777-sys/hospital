import java.util.*

data class Patient(
    val id: Int,
    var name: String,
    var age: Int,
    var disease: String
)

class HospitalManagementSystem {
    private val patientList = mutableListOf<Patient>()

    fun addPatient() {
        val scanner = Scanner(System.`in`)

        print("Enter Patient ID: ")
        val id = scanner.nextInt()
        scanner.nextLine()

        print("Enter Patient Name: ")
        val name = scanner.nextLine()

        print("Enter Patient Age: ")
        val age = scanner.nextInt()
        scanner.nextLine()

        print("Enter Disease: ")
        val disease = scanner.nextLine()

        val patient = Patient(id, name, age, disease)
        patientList.add(patient)

        println("Patient Added Successfully!\n")
    }

    fun viewPatients() {
        if (patientList.isEmpty()) {
            println("No patients found.\n")
        } else {
            println("\n---- Patient Records ----")
            for (patient in patientList) {
                println("ID: ${patient.id}")
                println("Name: ${patient.name}")
                println("Age: ${patient.age}")
                println("Disease: ${patient.disease}")
                println("--------------------------")
            }
        }
    }

    fun searchPatient() {
        val scanner = Scanner(System.`in`)
        print("Enter Patient ID to Search: ")
        val id = scanner.nextInt()

        val patient = patientList.find { it.id == id }

        if (patient != null) {
            println("Patient Found:")
            println("Name: ${patient.name}")
            println("Age: ${patient.age}")
            println("Disease: ${patient.disease}\n")
        } else {
            println("Patient Not Found.\n")
        }
    }

    fun deletePatient() {
        val scanner = Scanner(System.`in`)
        print("Enter Patient ID to Delete: ")
        val id = scanner.nextInt()

        val removed = patientList.removeIf { it.id == id }

        if (removed) {
            println("Patient Deleted Successfully!\n")
        } else {
            println("Patient Not Found.\n")
        }
    }
}

fun main() {
    val system = HospitalManagementSystem()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("===== Hospital Management System =====")
        println("1. Add Patient")
        println("2. View All Patients")
        println("3. Search Patient")
        println("4. Delete Patient")
        println("5. Exit")
        print("Enter your choice: ")

        when (scanner.nextInt()) {
            1 -> system.addPatient()
            2 -> system.viewPatients()
            3 -> system.searchPatient()
            4 -> system.deletePatient()
            5 -> {
                println("Exiting Program...")
                break
            }
            else -> println("Invalid Choice!\n")
        }
    }
}