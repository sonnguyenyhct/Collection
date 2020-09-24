import java.util.*;

public class ProductManager {
    public static LinkedList<Product> productLinkedList = new LinkedList<>();
    public static void main(String[] args) {

        productLinkedList.add(new Product(1,"Iphone X",20000000));
        productLinkedList.add(new Product(2,"Samsung s6",15000000));
        productLinkedList.add(new Product(3,"Oppo",5000000));
        productLinkedList.add(new Product(4,"Nokia 1280",50000000));
        productLinkedList.add(new Product(5,"Xiaomi",6000000));

        ProductManager productManager = new ProductManager();
        productManager.sortProductByPriceAscending();
        System.out.println("");
        productManager.sortProductByPriceDecrease();

    }
    Scanner scanner = new Scanner(System.in);
    public void addProduct(){
        System.out.println("Input name product : ");
        String name = scanner.nextLine();
        System.out.println("Input price product : ");
        double price = scanner.nextDouble();
        if (productLinkedList.add(new Product(productLinkedList.size() + 1,name,price))){
            System.out.println("Add success");
        }else {
            System.out.println("Add error");
        }
    }

    public void editProduct(){
        System.out.println("Input ID product want to edit : ");
        int id = scanner.nextInt();
        if (id >=1 && id <= productLinkedList.size()){
            System.out.println("Input new name of product " + productLinkedList.get(id-1).getName() +  " : ");
            String newName = scanner.nextLine();
            productLinkedList.get(id-1).setName(newName);
            System.out.println("Edit success");
        }else {
            System.out.println("ID not found. ");
        }
    }

    public void deleteProduct(){
        System.out.println("Input ID product want to delete : ");
        int id = scanner.nextInt();
        if (id >=1 && id <= productLinkedList.size()){
            productLinkedList.remove(id-1);
            System.out.println("Delete success");
        }else {
            System.out.println("ID not found. ");
        }
    }

    public void displayListProduct(){
        for (Product product : productLinkedList){
            System.out.println(product.toString());
        }
    }

    public void findProductByName(){
        System.out.println("Input name product want to find : ");
        String nameNeedFind = scanner.nextLine();
        boolean checkFind = true;
        for (Product product : productLinkedList){
            if (nameNeedFind.equals(product.getName())){
                System.out.println(product.toString());
                checkFind = false;
            }
        }
        if (checkFind){
            System.out.println("Name not found. ");
        }
    }

    public void sortProductByPriceAscending(){
        Collections.sort(productLinkedList);
        displayListProduct();
    }
    public void sortProductByPriceDecrease(){
        Collections.reverse(productLinkedList);
        displayListProduct();
    }


}
